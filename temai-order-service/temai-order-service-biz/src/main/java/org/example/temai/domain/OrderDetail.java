package org.example.temai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: hanchaowei
 * @date 2023/10/11
 * @description:
 */
@TableName("order_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class OrderDetail extends Base {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 订单id
	 */
	private Long orderId;

	/**
	 * 商品id
	 */
	private Long productId;

	/**
	 * 供应商id
	 */
	private Long supplierId;

	/**
	 * 商品单价
	 */
	private Double productPrice;

	/**
	 * 商品数量
	 */
	private Integer productTotal;

	/**
	 * 子订单总金额
	 */
	private Double totalPrice;

	/**
	 * 子订单状态
	 */
	private Integer orderStatus;

	/**
	 * 发货状态
	 */
	private Integer shipmentStatus;

	/**
	 * 发货时间
	 */
	private String shipmentTime;
}
