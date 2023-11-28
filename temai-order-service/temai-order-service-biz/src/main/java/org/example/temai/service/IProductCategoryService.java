package org.example.temai.service;

import org.example.temai.vo.ProductCategoryReq;
import org.example.temai.vo.ProductCategoryRsp;

/**
 * @author: hanchaowei
 * @date 2023/11/28
 * @description:
 */

public interface IProductCategoryService {

	/**
	 * 创建分类
	 * @param productCategoryReq
	 */
	void createProductCategory(ProductCategoryReq productCategoryReq);

	/**
	 * 更新分类
	 * @param productCategoryReq
	 */
	void updateProductCategory(ProductCategoryReq productCategoryReq);

	/**
	 * 删除分类
	 * @param id
	 */
	void deleteProductCategory(Long id);

	/**
	 * 查询分类
	 * @param id
	 * @return
	 */
	ProductCategoryRsp queryProductCategory(Long id);

}
