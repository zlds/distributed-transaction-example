package org.example.temai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: hanchaowei
 * @date 2023/10/26
 * @description:
 */
@TableName("product_stock_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class ProductStockLog extends Base {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 商品ID
	 */
	private Long productId;

	/**
	 * 操作类型：增加或扣减
	 * 1：增加,2：扣减
	 */
	private Integer operationType;

	/**
	 * 变动数量
	 */
	private Integer quantity;

	/**
	 * 变动前的库存数量
	 */
	private Integer previousStock;

	/**
	 * 变动后的库存数量
	 */
	private Integer currentStock;

	/**
	 * 操作时间
	 */
	private Date operationTime;

}
