package org.example.temai.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: hanchaowei
 * @date 2023/10/26
 * @description: 库存操作类型
 */
@Getter
@AllArgsConstructor
public enum ProductStockOperationTypeEnum {

	/**
	 * 添加库存
	 */
	ADD(1, "添加库存"),

	/**
	 * 扣减库存
	 */
	DEDUCT(2, "扣减库存");

	private final Integer type;
	private final String description;

}
