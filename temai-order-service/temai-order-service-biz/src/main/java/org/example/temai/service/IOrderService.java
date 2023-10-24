package org.example.temai.service;

import org.example.temai.vo.ProductItemReq;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/10/15
 * @description: 订单服务
 */

public interface IOrderService {

	/**
	 * 创建订单
	 * @param addressId 收货地址
	 * @param productList 商品列表
	 */
	void createOrder(Long addressId, List<ProductItemReq> productList);

	/**
	 * 查询订单
	 */
	void queryOrder();

	/**
	 * 更新订单
	 */
	void updateOrder();

	/**
	 * 删除订单
	 */
	void deleteOrder();

	/**
	 * 查询订单详情
	 */
	void queryOrderDetail();

}
