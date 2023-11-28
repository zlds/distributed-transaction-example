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
 * @description: 商品品牌表
 */
@TableName(value = "product_brand")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class ProductBrand extends Base {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 品牌名称
	 */
	private String brandName;

	/**
	 * 品牌描述
	 */
	private String description;

	/**
	 * 品牌Logo
	 */
	private String logoUrl;

}
