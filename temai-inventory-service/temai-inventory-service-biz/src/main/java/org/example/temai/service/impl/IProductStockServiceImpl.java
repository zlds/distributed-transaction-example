package org.example.temai.service.impl;

import org.example.temai.dao.ProductStockLogMapper;
import org.example.temai.dao.ProductStockMapper;
import org.example.temai.domain.ProductStock;
import org.example.temai.domain.ProductStockLog;
import org.example.temai.framework.common.enums.ProductStockOperationTypeEnum;
import org.example.temai.service.IProductStockLogService;
import org.example.temai.service.IProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
		addProductStock.setOperatorId("1");
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
			productStock.setQuantity(currentQuantity - quantity);
		}
		// 更新库存
		productStockMapper.updateById(productStock);
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
}
