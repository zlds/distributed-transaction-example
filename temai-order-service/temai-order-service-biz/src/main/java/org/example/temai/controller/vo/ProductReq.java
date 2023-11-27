package org.example.temai.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: hanchaowei
 * @date 2023/11/27
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class ProductReq {

	/**
	 * 商品名称
	 */
	private String productName;

	/**
	 * 商品描述
	 */
	private String description;

	/**
	 * 品牌ID
	 */
	private Long brandId;

	/**
	 * 分类ID
	 */
	private Long categoryId;

	/**
	 * 商品价格
	 */
	private Long price;

	/**
	 * 商品缩略图
	 */
	private String thumbnail;

	/**
	 * 商品图片
	 */
	private String images;

	/**
	 * 商品状态
	 */
	private Integer status;

	/**
	 * 店铺ID
	 */
	private Long shopId;
}
