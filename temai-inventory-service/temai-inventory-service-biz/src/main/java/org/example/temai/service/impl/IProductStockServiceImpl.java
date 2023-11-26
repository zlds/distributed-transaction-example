package org.example.temai.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.example.temai.dao.ProductStockLogMapper;
import org.example.temai.dao.ProductStockMapper;
import org.example.temai.domain.ProductStock;
import org.example.temai.domain.ProductStockLog;
import org.example.temai.dto.ProductStockDTO;
import org.example.temai.framework.common.enums.ProductStockOperationTypeEnum;
import org.example.temai.framework.common.exception.ServiceException;
import org.example.temai.service.IProductStockLogService;
import org.example.temai.service.IProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/10/26
 * @description:
 */
@Service
public class IProductStockServiceImpl implements IProductStockService {

	@Autowired
	private ProductStockMapper productStockMapper;
	@Autowired
	private IProductStockLogService iProductStockLogService;


	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer stockIn(Long productId, Integer quantity) {
		ProductStock addProductStock = new ProductStock();
		addProductStock.setProductId(productId);
		addProductStock.setQuantity(quantity);
		// TODO 操作人id临时写死
		addProductStock.setOperatorId(1L);
		productStockMapper.insert(addProductStock);
		// 记录日志
		ProductStockLog productStockLog = ProductStockLog.
						builder()
				.productId(productId)
				.quantity(quantity)
				.previousStock(addProductStock.getQuantity())
				.currentStock(addProductStock.getQuantity())
				.operationTime(new Date())
				.operationType(ProductStockOperationTypeEnum.STOCK_IN.getType())
				.build();
		iProductStockLogService.add(productStockLog);
		return addProductStock.getQuantity();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer deduct(Long productId, Integer quantity) {
		return updateStock(productId,quantity,ProductStockOperationTypeEnum.DEDUCT.getType());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer add(Long productId, Integer quantity) {
		return updateStock(productId,quantity,ProductStockOperationTypeEnum.ADD.getType());
	}

	private Integer updateStock(Long productId, Integer quantity, Integer operationType) {
		// 获取当前库存
		ProductStock productStock = productStockMapper.findByProductId(productId);
		Integer currentQuantity = productStock.getQuantity();
		if (currentQuantity <= 0 && operationType.equals(ProductStockOperationTypeEnum.ADD.getType())) {
			return 0;
		}
		if (operationType.equals(ProductStockOperationTypeEnum.ADD.getType())) {
			productStock.setQuantity(currentQuantity + quantity);
		} else if (operationType.equals(ProductStockOperationTypeEnum.DEDUCT.getType())) {
			if (currentQuantity < quantity) {
				// 当前库存不足，不能扣减
				throw new ServiceException("库存不足，无法扣减");
			}
			productStock.setQuantity(currentQuantity - quantity);
		}
		UpdateWrapper<ProductStock> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("id", productStock.getId())
				.set("quantity", productStock.getQuantity());

		// 更新库存
		productStockMapper.update(null, updateWrapper);
		// 记录日志
		ProductStockLog productStockLog = ProductStockLog.
						builder()
				.productId(productId)
				.quantity(quantity)
				.previousStock(currentQuantity)
				.currentStock(productStock.getQuantity())
				.operationTime(new Date())
				.operationType(operationType)
				.build();
		iProductStockLogService.add(productStockLog);
		return productStockLog.getQuantity();
	}

	@Override
	public Integer getStock(Long productId) {
		ProductStock productStock = productStockMapper.findByProductId(productId);
		if (productStock != null) {
			return productStock.getQuantity();
		}
		return -1;
	}

	@Override
	public Integer getAlertLevel(Long productId) {
		ProductStock productStock = productStockMapper.findByProductId(productId);
		return productStock.getAlertLevel();
	}

	@Override
	public boolean setAlertLevel(Long productId, Integer alertLevel) {
		ProductStock productStock = productStockMapper.findByProductId(productId);
		if (productStock == null) {
			return false;
		}
		if (productStock.getAlertLevel() != null) {
			productStock.setAlertLevel(productStock.getAlertLevel() + alertLevel);
		}
		productStock.setAlertLevel(alertLevel);
		int updatedRows = productStockMapper.updateById(productStock);
		return updatedRows > 0;
	}

	@Override
	public boolean isBelowAlertLevel(Long productId) {
		ProductStock productStock = productStockMapper.findByProductId(productId);
		return productStock.getQuantity() <= productStock.getAlertLevel();
	}

	@Override
	public List<ProductStockDTO> getStockListByProductIds(List<Long> productIdList) {
		List<ProductStockDTO> result = new ArrayList<>();
		List<ProductStock> productStockList = productStockMapper.findByProductIds(productIdList);
		if (productStockList != null) {
			for (ProductStock productStock : productStockList) {
				ProductStockDTO productStockDTO = new ProductStockDTO();
				productStockDTO.setProductId(productStock.getProductId());
				productStockDTO.setStock(productStock.getQuantity());
				result.add(productStockDTO);
			}
		}
		return result;
	}
}
