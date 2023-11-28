package org.example.temai.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: hanchaowei
 * @date 2023/10/22
 * @description: 商品
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductItemReq {

	/**
	 * 商品id
	 */
	private Long productId;

	/**
	 * 商品数量
	 */
	private Integer productQuantity;

	/**
	 * 商品名称
	 */
	private String productName;

	/**
	 * 商品sku
	 */
	private Long skuId;

	/**
	 * 店铺id
	 */
	private Long shopId;

	/**
	 * 店铺名称
	 */
	private String shopName;
}
