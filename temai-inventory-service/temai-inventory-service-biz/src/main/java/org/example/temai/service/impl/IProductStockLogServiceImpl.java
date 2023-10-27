package org.example.temai.service.impl;

import org.example.temai.dao.ProductStockLogMapper;
import org.example.temai.domain.ProductStockLog;
import org.example.temai.service.IProductStockLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2023/10/27
 * @description:
 */
@Service
public class IProductStockLogServiceImpl implements IProductStockLogService {

	@Autowired
	private ProductStockLogMapper productStockLogMapper;

	@Override
	public void add(ProductStockLog stockLog) {
		productStockLogMapper.insert(stockLog);
	}
}
