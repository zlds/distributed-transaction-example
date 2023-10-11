package org.example.temai.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class IUserPointServiceTest {

	@Autowired
	IUserPointsService iUserPointsService;

	/**
	 * 查询积分
	 */
	@Test
	public void get() {
		Integer userPoints = iUserPointsService.getUserPoints(1L);
		System.out.println(userPoints);
	}

	/**
	 * 添加积分
	 */
	@Test
	public void add() {
		iUserPointsService.addUserPoints(1L, 100, 1L, 100);
	}

	/**
	 * 扣减积分
	 */
	@Test
	public void update() {
		iUserPointsService.subtractUserPoints(1L, 100, 1L, 1);
	}



}