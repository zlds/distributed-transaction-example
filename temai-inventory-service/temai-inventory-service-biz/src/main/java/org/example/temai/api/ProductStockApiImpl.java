package org.example.temai.api;

import org.example.temai.dto.ProductStockDTO;
import org.example.temai.framework.common.pojo.CommonResult;
import org.example.temai.service.IProductStockService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/11/11
 * @description:
 */

public class ProductStockApiImpl implements ProductStockApi {

	@Autowired
	private IProductStockService productStockService;


	@Override
	public CommonResult<List<ProductStockDTO>> getStockListByProductIds(List<Long> productIdList) {
		List<ProductStockDTO> stockDTOList = productStockService.getStockListByProductIds(productIdList);
		return CommonResult.success(stockDTOList);
	}
}
