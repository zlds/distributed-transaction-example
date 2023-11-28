package org.example.temai.vo;

import lombok.Data;

/**
 * @author: hanchaowei
 * @date 2023/11/28
 * @description:
 */
@Data
public class ProductBrandReq {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 品牌名称
	 */
	private String brandName;

	/**
	 * 品牌描述
	 */
	private String description;

	/**
	 * 品牌Logo
	 */
	private String logoUrl;
}
