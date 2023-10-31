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
 * @description: 商品分类表
 */
@TableName(value = "product_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class ProductCategory extends Base {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 分类名称
	 */
	private String categoryName;

	/**
	 * 父分类ID
	 */
	private Long parentId;

	/**
	 * 分类描述
	 */
	private String description;

}
