package org.example.temai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: hanchaowei
 * @date 2023/10/25
 * @description: 库存服务
 */
@SpringBootApplication
@MapperScan("org.example.temai.dao")
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
}
