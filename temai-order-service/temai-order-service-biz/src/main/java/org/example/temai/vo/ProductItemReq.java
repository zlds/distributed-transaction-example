package org.example.temai.vo;

import lombok.Data;

/**
 * @author: hanchaowei
 * @date 2023/10/22
 * @description: 商品
 */
@Data
public class ProductItemReq {

	/**
	 * 商品id
	 */
	private Long productId;

	/**
	 * 商品数量
	 */
	private Integer productQuantity;


}
