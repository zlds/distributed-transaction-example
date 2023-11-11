package org.example.temai.dto;

import lombok.Data;

/**
 * @author: hanchaowei
 * @date 2023/11/6
 * @description: 库存DTO
 */
@Data
public class ProductStockDTO {

	/**
	 * 商品id
	 */
	private Long productId;

	/**
	 * 库存数量
	 */
	private Integer stock;


}
