package org.example.temai.service;

import org.example.temai.dao.ProductBrandMapper;
import org.example.temai.domain.ProductBrand;
import org.example.temai.framework.common.util.SnowflakeIdUtils;
import org.example.temai.vo.ProductBrandReq;
import org.example.temai.vo.ProductBrandRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2023/11/28
 * @description:
 */
@Service
public class IProductBrandServiceImpl implements IProductBrandService {

	@Autowired
	private ProductBrandMapper productBrandMapper;

	@Override
	public void createBrand(ProductBrandReq productBrandReq) {
		ProductBrand productBrand = new ProductBrand();
		productBrand.setId(SnowflakeIdUtils.nextId());
		productBrand.setBrandName(productBrandReq.getBrandName());
		productBrand.setDescription(productBrandReq.getDescription());
		productBrand.setLogoUrl(productBrandReq.getLogoUrl());
		productBrandMapper.insert(productBrand);
	}

	@Override
	public void updateBrand(ProductBrandReq productBrandReq) {
		ProductBrand productBrand = new ProductBrand();
		productBrand.setId(productBrandReq.getId());
		productBrand.setBrandName(productBrandReq.getBrandName());
		productBrand.setDescription(productBrandReq.getDescription());
		productBrand.setLogoUrl(productBrandReq.getLogoUrl());
		productBrandMapper.updateById(productBrand);
	}

	@Override
	public void deleteBrand(Long brandId) {
		productBrandMapper.deleteById(brandId);
	}

	@Override
	public ProductBrandRsp getBrandById(Long brandId) {
		ProductBrand productBrand = productBrandMapper.selectById(brandId);
		if (productBrand != null) {
			ProductBrandRsp productBrandRsp = new ProductBrandRsp();
			productBrandRsp.setId(productBrand.getId());
			productBrandRsp.setBrandName(productBrand.getBrandName());
			productBrandRsp.setDescription(productBrand.getDescription());
			productBrandRsp.setLogoUrl(productBrand.getLogoUrl());
			return productBrandRsp;
		}
		return null;
	}

	@Override
	public String getBrandNameById(Long brandId) {
		ProductBrand productBrand = productBrandMapper.selectById(brandId);
		if (productBrand != null) {
			return productBrand.getBrandName();
		}
		return null;
	}
}
