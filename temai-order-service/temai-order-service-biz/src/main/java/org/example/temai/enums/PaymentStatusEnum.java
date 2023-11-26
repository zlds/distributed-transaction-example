package org.example.temai.enums;

/**
 * @author: hanchaowei
 * @date 2023/11/25
 * @description: 支付状态
 */

public enum PaymentStatusEnum {

	/**
	 * 未支付
	 */
	UNPAID("未支付",0),
	/**
	 * 支付成功
	 */
	SUCCESS("支付成功",1),
	/**
	 * 支付失败
	 */
	FAILED("支付失败",2);

	private String description;
	private Integer value;

	PaymentStatusEnum(String description, Integer value) {
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
