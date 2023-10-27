package org.example.temai.service;

import org.example.temai.domain.ProductStockLog;

/**
 * @author: hanchaowei
 * @date 2023/10/27
 * @description:
 */

public interface IProductStockLogService {

	/**
	 * 添加库存日志
	 * @param stockLog
	 */
	void add(ProductStockLog stockLog);
}
