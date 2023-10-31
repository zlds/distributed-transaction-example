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
 * @description: 商品表
 */
@TableName(value = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Product extends Base {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 商品名称
	 */
	private String productName;

	/**
	 * 商品描述
	 */
	private String description;

	/**
	 * 品牌ID
	 */
	private Long brandId;

	/**
	 * 分类ID
	 */
	private Long categoryId;

	/**
	 * 商品价格
	 */
	private Double price;

	/**
	 * 商品缩略图
	 */
	private String thumbnail;

	/**
	 * 商品图片
	 */
	private String images;

	/**
	 * 商品状态
	 */
	private String status;

}
