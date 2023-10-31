package org.example.temai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: hanchaowei
 * @date 2023/10/24
 * @description: 商品评价表
 */
@TableName(value = "product_review")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class ProductReview extends Base {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 商品ID
	 */
	private Long productId;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 评分
	 */
	private Integer rating;

	/**
	 * 评价内容
	 */
	private String comment;

}
