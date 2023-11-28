package org.example.temai.service;

import org.example.temai.dao.ProductCategoryMapper;
import org.example.temai.domain.ProductCategory;
import org.example.temai.framework.common.util.SnowflakeIdUtils;
import org.example.temai.vo.ProductCategoryReq;
import org.example.temai.vo.ProductCategoryRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2023/11/28
 * @description:
 */
@Service
public class IProductCategoryServiceImpl implements IProductCategoryService {

	@Autowired
	private ProductCategoryMapper productCategoryMapper;

	@Override
	public void createProductCategory(ProductCategoryReq productCategoryReq) {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(SnowflakeIdUtils.nextId());
		productCategory.setCategoryName(productCategoryReq.getCategoryName());
		productCategory.setDescription(productCategoryReq.getDescription());
		productCategory.setParentId(productCategoryReq.getParentId());
		productCategoryMapper.insert(productCategory);
	}

	@Override
	public void updateProductCategory(ProductCategoryReq productCategoryReq) {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(productCategoryReq.getId());
		productCategory.setCategoryName(productCategoryReq.getCategoryName());
		productCategory.setDescription(productCategoryReq.getDescription());
		productCategory.setParentId(productCategoryReq.getParentId());
		productCategoryMapper.updateById(productCategory);
	}

	@Override
	public void deleteProductCategory(Long id) {
		int i = productCategoryMapper.deleteById(id);
	}

	@Override
	public ProductCategoryRsp queryProductCategory(Long id) {
		ProductCategory productCategory = productCategoryMapper.selectById(id);
		if (productCategory != null) {
			ProductCategoryRsp productCategoryRsp = new ProductCategoryRsp();
			productCategoryRsp.setId(productCategory.getId());
			productCategoryRsp.setCategoryName(productCategory.getCategoryName());
			productCategoryRsp.setDescription(productCategory.getDescription());
			productCategoryRsp.setParentId(productCategory.getParentId());
			return productCategoryRsp;
		}
		return null;
	}
}
