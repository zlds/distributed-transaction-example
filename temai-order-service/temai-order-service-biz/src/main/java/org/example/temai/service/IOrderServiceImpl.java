package org.example.temai.service;


import cn.hutool.core.util.ObjectUtil;
import org.example.temai.api.user.UserApi;
import org.example.temai.api.user.dto.UserAddressRespDTO;
import org.example.temai.framework.common.pojo.CommonResult;
import org.example.temai.vo.ProductItemReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.temai.framework.common.exception.enums.ErrorCodeConstants.*;
import static org.example.temai.framework.common.exception.util.ServiceExceptionUtil.exception;


/**
 * @author: hanchaowei
 * @date 2023/10/22
 * @description:
 */
@Service
public class IOrderServiceImpl implements IOrderService {

	@Resource
	private UserApi userApi;


	@Override
	public void createOrder(Long addressId, List<ProductItemReq> productList) {
		if (addressId == null || productList == null) {
			throw exception(PARAM_ERROR);
		}

		// 检查库存 TODO 未实现库存服务功能
		List<Long> productIds = productList.stream().map(ProductItemReq::getProductId).collect(Collectors.toList());


		// 1. 校验收货地址
		UserAddressRespDTO addressInfo = userApi.getAddressInfoById(addressId).getData();
		if (ObjectUtil.isNull(addressInfo)) {
			throw exception(ADDRESS_NOT_EXIST);
		}

		// 2. 校验支付方式
		// 3. 校验商品列表
		// 4. 创建订单
		// 5. 创建订单详情



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