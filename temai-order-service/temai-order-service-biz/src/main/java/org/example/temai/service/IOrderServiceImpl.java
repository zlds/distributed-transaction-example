package org.example.temai.service;


import cn.hutool.core.util.ObjectUtil;
import org.example.temai.api.ProductStockApi;
import org.example.temai.api.user.UserApi;
import org.example.temai.api.user.dto.UserAddressRespDTO;
import org.example.temai.dao.OrderDetailMapper;
import org.example.temai.dao.OrderMapper;
import org.example.temai.dao.OrderSequenceMapper;
import org.example.temai.domain.Order;
import org.example.temai.domain.OrderDetail;
import org.example.temai.domain.Product;
import org.example.temai.dto.ProductStockDTO;
import org.example.temai.enums.OrderStatusEnum;
import org.example.temai.enums.PaymentStatusEnum;
import org.example.temai.framework.common.pojo.CommonResult;
import org.example.temai.framework.common.util.SnowflakeIdUtils;
import org.example.temai.util.OrderUtils;
import org.example.temai.vo.ProductItemReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.example.temai.framework.common.exception.enums.ErrorCodeConstants.*;
import static org.example.temai.framework.common.exception.util.ServiceExceptionUtil.*;


/**
 * @author: hanchaowei
 * @date 2023/10/22
 * @description:
 */
@Service
public class IOrderServiceImpl implements IOrderService {

	@Resource
	private UserApi userApi;
	@Resource
	private ProductStockApi productStockApi;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	@Resource
	private IProductService iProductService;
	@Autowired
	private OrderSequenceMapper orderSequenceMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void createOrder(Long addressId, List<ProductItemReq> productListReq) {
		if (addressId == null || productListReq == null) {
			throw exception(PARAM_ERROR);
		}
		// 校验收货地址
		UserAddressRespDTO addressInfo = userApi.getAddressInfoById(addressId).getData();
		if (ObjectUtil.isNull(addressInfo)) {
			throw exception(ADDRESS_NOT_EXIST);
		}
		// 检查库存
		List<Long> productIds = productListReq.stream().map(ProductItemReq::getProductId).collect(Collectors.toList());
		List<ProductStockDTO> productStockDTOS = productStockApi.getStockListByProductIds(productIds).getData();
		if (productStockDTOS == null || productStockDTOS.size() == 0) {
			throw exception(PRODUCT_NOT_EXIST);
		}
		Map<Long, Integer> stockMap = productStockDTOS.stream()
				.collect(Collectors.toMap(ProductStockDTO::getProductId, ProductStockDTO::getStock));
		for (ProductItemReq item : productListReq) {
			Integer stockQuantity = stockMap.getOrDefault(item.getProductId(), 0);
			if (item.getProductQuantity() > stockQuantity) {
				// 如果请求的数量大于库存数量，抛出异常
				throw exceptionCommon(200,"商品库存不足" + item.getProductId() + "，当前库存：" + stockQuantity);
			}
		}
		// 计算价格
		List<Product> productList = iProductService.getProductListByIds(productIds);
		Map<Long, Long> productPriceMap = productList.stream().collect(Collectors.toMap(Product::getId, Product::getPrice));
		Long totalAmount = 0L;
		for (ProductItemReq itemReq : productListReq) {
			Long price = productPriceMap.get(itemReq.getProductId());
			totalAmount += price * itemReq.getProductQuantity();
		}
		// 创建订单
		Order order = new Order();
		order.setId(SnowflakeIdUtils.nextId());
		order.setUserId(1L);
		order.setTotalPrice(totalAmount);
		order.setOrderStatus(OrderStatusEnum.PENDING_PAYMENT.getValue());
		order.setPaymentStatus(PaymentStatusEnum.UNPAID.getValue());
		order.setOrderNumber(OrderUtils.generateOrderNumber(orderSequenceMapper));
		order.setOperatorId(1L);
		orderMapper.insert(order);
		// 创建订单详情
		List<OrderDetail> orderDetailList = productListReq.stream().map(item -> {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setId(SnowflakeIdUtils.nextId());
			orderDetail.setOrderId(order.getId());
			orderDetail.setProductId(item.getProductId());
			orderDetail.setProductTotal(item.getProductQuantity());
			orderDetail.setProductPrice(productPriceMap.get(item.getProductId()) * item.getProductQuantity());
			orderDetail.setOrderStatus(OrderStatusEnum.PENDING_PAYMENT.getValue());
			// 获取店铺id
			productList.stream().filter(product -> product.getId().equals(item.getProductId())).findFirst().ifPresent(product -> {
				orderDetail.setSupplierId(product.getShopId());
			});
			orderDetail.setOperatorId(1L);
			return orderDetail;
		}).collect(Collectors.toList());
		orderDetailMapper.batchInsert(orderDetailList);
	}

	@Override
	public void queryOrder() {

	}

	@Override
	public void updateOrder() {

	}

	@Override
	public void deleteOrder() {

	}

	@Override
	public void queryOrderDetail() {

	}
}
