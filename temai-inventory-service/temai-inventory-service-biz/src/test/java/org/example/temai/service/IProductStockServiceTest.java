package org.example.temai.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IProductStockServiceTest {

	@Autowired
	private IProductStockService iProductStockService;


	@Test
	void stockIn() {
		iProductStockService.stockIn(1L, 1);
	}
	@Test
	void deduct() {
		iProductStockService.deduct(2L, 7);
	}

	@Test
	void add() {
		iProductStockService.add(2L, 10);
	}

	@Test
	void getStock() {
		Integer stock = iProductStockService.getStock(1L);
		System.out.println(stock);
	}

	@Test
	void getAlertLevel() {
		iProductStockService.getAlertLevel(1L);
	}

	@Test
	void setAlertLevel() {
		iProductStockService.setAlertLevel(1L, 5);
	}

	@Test
	void isBelowAlertLevel() {
		boolean belowAlertLevel = iProductStockService.isBelowAlertLevel(1L);
		System.out.println(belowAlertLevel);
	}
}