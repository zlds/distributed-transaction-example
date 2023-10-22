package org.example.temai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: hanchaowei
 * @date 2023/10/22
 * @description: 订单服务
 */
@SpringBootApplication
@MapperScan("org.example.temai.dao")
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
