package org.example.temai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.example.temai.framework.common.domain.Base;

/**
 * @author: hanchaowei
 * @date 2023/10/24
 * @description: 商品图片表
 */
@TableName(value = "product_image")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class ProductImage extends Base {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 商品ID
	 */
	private Long productId;

	/**
	 * 图片地址
	 */
	private String imageUrl;

	/**
	 * 是否缩略图
	 */
	private Boolean isThumbnail;
}
