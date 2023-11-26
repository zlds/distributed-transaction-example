package org.example.temai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: hanchaowei
 * @date 2023/11/26
 * @description: 订单序列
 */
@TableName("order_sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class OrderSequence extends Base {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 序列值
	 */
	private Long nextId;

}
