package org.example.temai.service;

/**
 * @author: hanchaowei
 * @date 2023/10/7
 * @description: 用户积分服务
 */

public interface IUserPointsService {

	/**
	 * 添加用户积分
	 * @param userId
	 * @param points
	 */
	void addUserPoints(Long userId, Integer points);

	/**
	 * 扣减用户积分
	 * @param userId 用户id
	 * @param points 积分
	 * @param pointType 来源id
	 * @param transactionId 来源类型
	 */
	void subtractUserPoints(Long userId, Integer points, Long transactionId, Integer pointType);

	/**
	 * 查询用户积分
	 * @param userId
	 * @return
	 */
	Integer getUserPoints(Long userId);
}
