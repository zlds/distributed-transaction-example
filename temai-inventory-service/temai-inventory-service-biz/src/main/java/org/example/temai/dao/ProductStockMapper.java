package org.example.temai.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.temai.domain.ProductStock;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/10/25
 * @description:
 */
@Mapper
public interface ProductStockMapper extends BaseMapper<ProductStock> {

	/**
	 * 根据商品id查询库存
	 * @param productId
	 * @return
	 */
	@Select("select * from product_stock where product_id = #{productId}")
	ProductStock findByProductId(Long productId);

	/**
	 * 根据商品id列表查询库存
	 * @param productIds
	 * @return
	 */
	List<ProductStock> findByProductIds(List<Long> productIds);
}
