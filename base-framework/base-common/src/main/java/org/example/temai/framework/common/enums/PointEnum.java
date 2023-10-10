package org.example.temai.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: hanchaowei
 * @date 2023/10/10
 * @description: 积分枚举
 */
@Getter
@AllArgsConstructor
public enum PointEnum {


	/**
	 * 订单
	 */
	ORDER(1, "订单"),

	/**
	 * 签到
	 */
	SIGN_IN(2, "签到"),

	/**
	 * 抽奖
	 */
	LOTTERY(3, "抽奖");

	private Integer type;
	private String name;
}
