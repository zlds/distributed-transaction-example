package org.example.temai.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.temai.domain.ProductCategory;

/**
 * @author: hanchaowei
 * @date 2023/10/24
 * @description:
 */
@Mapper
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {
}
