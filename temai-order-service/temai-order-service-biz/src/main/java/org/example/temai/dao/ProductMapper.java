package org.example.temai.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.temai.domain.Product;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/10/24
 * @description:
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

	/**
	 * 根据商品id列表查询商品列表
	 * @param productIds
	 * @return
	 */
	@Select("<script>" +
			"SELECT * FROM product WHERE id IN " +
			"<foreach collection='productIds' item='productId' open='(' separator=',' close=')'>" +
			"#{productId}" +
			"</foreach>" +
			"</script>")
	List<Product> getProductListByIds(List<Long> productIds);


}
