package org.example.temai.enums;

/**
 * @author: hanchaowei
 * @date 2023/11/25
 * @description: 订单状态
 */

public enum OrderStatusEnum {

	/**
	 * 等待付款
	 */
	PENDING_PAYMENT("等待付款",0),
	/**
	 * 已付款
	 */
	PAID("已付款",1),
	/**
	 * 付款失败
	 */
	PAYMENT_FAILED("付款失败",2),
	/**
	 * 待发货
	 */
	PENDING_SHIPMENT("待发货",3),
	/**
	 * 已发货
	 */
	SHIPPED("已发货",4),
	/**
	 * 已收货
	 */
	RECEIVED("已收货",5),
	/**
	 * 交易完成
	 */
	COMPLETED("交易完成",6),
	/**
	 * 交易关闭
	 */
	CANCELED("已取消",7),
	/**
	 * 退款中
	 */
	RETURN_REQUESTED("退换货申请",8),
	/**
	 * 已退款
	 */
	RETURNED("已退换货",9);

	private String description;
	private Integer value;

	OrderStatusEnum(String description, Integer value) {
		this.description = description;
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public Integer getValue() {
		return value;
	}
}
