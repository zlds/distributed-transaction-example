package org.example.temai.service;

import org.example.temai.controller.vo.ProductReq;
import org.example.temai.dao.ProductMapper;
import org.example.temai.domain.Product;
import org.example.temai.framework.common.util.SnowflakeIdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/11/25
 * @description:
 */
@Service
public class IProductServiceImpl implements IProductService {
	@Autowired
	private ProductMapper productMapper;

	@Override
	public void queryProductList() {

	}

	@Override
	public void queryProductDetail() {

	}

	@Override
	public void updateProduct() {

	}

	@Override
	public void deleteProduct(Long id) {
		int i = productMapper.deleteById(id);
	}

	@Override
	public void createProduct(ProductReq productReq) {
		Product product = new Product();
		product.setId(SnowflakeIdUtils.nextId());
		product.setProductName(productReq.getProductName());
		product.setDescription(productReq.getDescription());
		product.setPrice(productReq.getPrice());
		product.setBrandId(productReq.getBrandId());
		product.setCategoryId(productReq.getCategoryId());
		product.setStatus(1);
		product.setShopId(productReq.getShopId());
		productMapper.insert(product);
	}

	@Override
	public List<Product> getProductListByIds(List<Long> productIds) {
		return productMapper.getProductListByIds(productIds);
	}
}
