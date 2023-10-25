package org.example.temai.service;

/**
 * @author: hanchaowei
 * @date 2023/10/25
 * @description: 库存服务
 */

public interface IProductStockService {

	/**
	 * 扣减库存
	 * @param productId 商品id
	 * @param quantity 数量
	 * @return
	 */
	boolean deduct(Long productId, Integer quantity);

	/**
	 * 增加库存
	 * @param productId 商品id
	 * @param quantity 数量
	 * @return
	 */
	boolean add(Long productId, Integer quantity);

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
	 * 获取库存预警状态
	 * @param productId 商品id
	 * @return
	 */
	boolean getAlertStatus(Long productId);

	/**
	 * 设置库存预警状态
	 * @param productId 商品id
	 * @param alertStatus 预警状态
	 * @return
	 */
	boolean setAlertStatus(Long productId, boolean alertStatus);
}
