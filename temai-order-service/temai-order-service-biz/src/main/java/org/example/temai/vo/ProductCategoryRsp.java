package org.example.temai.vo;

import lombok.Data;

/**
 * @author: hanchaowei
 * @date 2023/11/28
 * @description:
 */
@Data
public class ProductCategoryRsp {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 分类名称
	 */
	private String categoryName;

	/**
	 * 父分类ID
	 */
	private Long parentId;

	/**
	 * 分类描述
	 */
	private String description;
}
