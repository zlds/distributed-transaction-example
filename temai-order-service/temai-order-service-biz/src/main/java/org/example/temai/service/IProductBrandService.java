package org.example.temai.service;

import org.example.temai.vo.ProductBrandReq;
import org.example.temai.vo.ProductBrandRsp;

/**
 * @author: hanchaowei
 * @date 2023/11/28
 * @description:
 */

public interface IProductBrandService {

	/**
	 * 创建品牌
	 * @param productBrandReq
	 */
	void createBrand(ProductBrandReq productBrandReq);

	/**
	 * 更新品牌
	 * @param productBrandReq
	 */
	void updateBrand(ProductBrandReq productBrandReq);

	/**
	 * 删除品牌
	 * @param brandId
	 */
	void deleteBrand(Long brandId);

	/**
	 * 根据品牌id查询品牌信息
	 * @param brandId
	 * @return
	 */
	ProductBrandRsp getBrandById(Long brandId);


	/**
	 * 根据品牌id查询品牌名称
	 * @param brandId
	 * @return
	 */
	String getBrandNameById(Long brandId);
}
