package org.example.temai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: hanchaowei
 * @date 2023/10/25
 * @description: 库存
 */
@TableName("product_stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class ProductStock {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 商品id
	 */
	private Long productId;

	/**
	 * 库存数量
	 */
	private Integer quantity;

	/**
	 * 库存警告阈值
	 */
	private Integer alertLevel;

}
