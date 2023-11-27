package org.example.temai.service;

import org.example.temai.controller.vo.ProductReq;
import org.example.temai.domain.Product;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/11/25
 * @description: 商品服务
 */

public interface IProductService {

	/**
	 * 查询商品列表
	 */
	void queryProductList();

	/**
	 * 查询商品详情
	 */
	void queryProductDetail();

	/**
	 * 更新商品
	 */
	void updateProduct();

	/**
	 * 删除商品
	 * @param id
	 */
	void deleteProduct(Long id);

	/**
	 * 创建商品
	 * @param productReq
	 */
	void createProduct(ProductReq productReq);

	/**
	 * 根据商品id列表查询商品列表
	 * @param productIds
	 * @return
	 */
	List<Product> getProductListByIds(List<Long> productIds);
}
