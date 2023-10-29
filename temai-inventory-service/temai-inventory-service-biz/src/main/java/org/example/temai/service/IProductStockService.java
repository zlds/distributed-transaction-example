package org.example.temai.service;

/**
 * @author: hanchaowei
 * @date 2023/10/25
 * @description: 库存服务
 */

public interface IProductStockService {

	/**
	 * 商品入库
	 * @param productId
	 * @param quantity
	 */
	Integer stockIn(Long productId, Integer quantity);

	/**
	 * 扣减库存
	 * @param productId 商品id
	 * @param quantity 数量
	 * @return
	 */
	Integer deduct(Long productId, Integer quantity);

	/**
	 * 增加库存
	 * @param productId 商品id
	 * @param quantity 数量
	 * @return
	 */
	Integer add(Long productId, Integer quantity);

	/**
	 * 获取库存
	 * @param productId 商品id
	 * @return
	 */
	Integer getStock(Long productId);

	/**
	 * 获取库存警告阈值
	 * @param productId 商品id
	 * @return
	 */
	Integer getAlertLevel(Long productId);

	/**
	 * 设置库存警告阈值
	 * @param productId 商品id
	 * @param alertLevel 阈值
	 * @return
	 */
	boolean setAlertLevel(Long productId, Integer alertLevel);

	/**
	 * 检查商品是否低于预警阈值
	 * @param productId 商品id
	 * @return true 如果低于阈值，否则 false
	 */
	boolean isBelowAlertLevel(Long productId);
}
