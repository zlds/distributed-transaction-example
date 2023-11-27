package org.example.temai.service;

import org.example.temai.controller.vo.ProductReq;
import org.example.temai.framework.common.util.CurrencyUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IProductServiceTest {

	@Autowired
	private IProductService iProductService;

	@Test
	void queryProductList() {
	}

	@Test
	void queryProductDetail() {
	}

	@Test
	void updateProduct() {
	}

	@Test
	void deleteProduct() {
	}

	@Test
	void createProduct() {
		ProductReq productReq = new ProductReq();
		productReq.setProductName("iPhone15");
		productReq.setDescription("百亿补贴");
		productReq.setPrice(CurrencyUtils.yuanToFen(15000.00));
		productReq.setStatus(1);
		productReq.setBrandId(1L);
		productReq.setCategoryId(1l);
		productReq.setShopId(1L);
		iProductService.createProduct(productReq);

	}

	@Test
	void getProductListByIds() {
	}
}