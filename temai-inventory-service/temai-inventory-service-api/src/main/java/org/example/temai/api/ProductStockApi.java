package org.example.temai.api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.example.temai.dto.ProductStockDTO;
import org.example.temai.framework.common.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/11/6
 * @description:
 */
@RestController
@FeignClient(name = "temai-inventory-service")
public interface ProductStockApi {

	String PREFIX = "temai-inventory-service" + "/inventory";

	/**
	 * 根据商品id列表获取商品数据
	 */
	@GetMapping(PREFIX + "/getStockList")
	@ApiOperation("根据商品id列表获取商品数据")
	@ApiImplicitParam(name = "productIdList", value = "商品id列表", example = "100", required = true)
	CommonResult<List<ProductStockDTO>> getStockList(@RequestParam("productIdList") List<Long> productIdList);



}
