package org.example.temai.service;

import org.example.temai.dao.ProductMapper;
import org.example.temai.domain.Product;
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
	public void deleteProduct() {

	}

	@Override
	public void createProduct() {

	}

	@Override
	public List<Product> getProductListByIds(List<Long> productIds) {
		return productMapper.getProductListByIds(productIds);
	}
}
