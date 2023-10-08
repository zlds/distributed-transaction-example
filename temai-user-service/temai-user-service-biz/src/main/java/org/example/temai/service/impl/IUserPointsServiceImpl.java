package org.example.temai.service.impl;

import org.example.temai.dao.UserPointsMapper;
import org.example.temai.domain.UserPoints;
import org.example.temai.service.IUserPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2023/10/7
 * @description:
 */
@Service
public class IUserPointsServiceImpl implements IUserPointsService {
	@Autowired
	private UserPointsMapper userPointsMapper;

	@Override
	public void addUserPoints(Long userId, Integer points) {
		UserPoints userPoints = new UserPoints();
		userPoints.setUserId(userId);
		// 新用户默认赠送100积分
		userPoints.setCurrentPoints(100);
		userPointsMapper.insert(userPoints);
	}

	@Override
	public void subtractUserPoints(Long userId, Integer points) {

	}

	@Override
	public Integer getUserPoints(Long userId) {
		return null;
	}
}
