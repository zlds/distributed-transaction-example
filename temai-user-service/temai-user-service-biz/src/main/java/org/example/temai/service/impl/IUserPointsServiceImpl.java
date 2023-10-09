package org.example.temai.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.temai.dao.UserPointDetailsMapper;
import org.example.temai.dao.UserPointsMapper;
import org.example.temai.domain.UserPoints;
import org.example.temai.framework.common.exception.ServiceException;
import org.example.temai.service.IUserPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: hanchaowei
 * @date 2023/10/7
 * @description:
 */
@Service
public class IUserPointsServiceImpl implements IUserPointsService {
	@Autowired
	private UserPointsMapper userPointsMapper;
	@Autowired
	private UserPointDetailsMapper userPointDetailsMapper;

	@Override
	public void addUserPoints(Long userId, Integer points) {
		UserPoints userPoints = new UserPoints();
		userPoints.setUserId(userId);
		// 新用户默认赠送100积分
		userPoints.setCurrentPoints(100);
		userPointsMapper.insert(userPoints);
		// 添加积分明细
	}

	@Override
	public void subtractUserPoints(Long userId, Integer points, Long transactionId, Integer pointType) {
		// 查询用户积分
		QueryWrapper<UserPoints> queryWrapper2 = new QueryWrapper<>();
		queryWrapper2.eq("user_id", userId);
		UserPoints userPoints = userPointsMapper.selectOne(queryWrapper2);
		if (userPoints == null) {
			throw new ServiceException("用户积分不存在");
		}
		// 查询积分明细，如果存在表示已经处理过了。 TODO 未完成
		QueryWrapper<UserPoints> queryWrapper1 = new QueryWrapper<>();
		queryWrapper1.eq("transaction_id", transactionId);
		queryWrapper1.eq("user_points_id", userPoints.getId());
		queryWrapper1.eq("user_id", userId);

		// 更新积分
		Integer currentPoints = userPoints.getCurrentPoints();
		int nowPoints = currentPoints - points;
		if (nowPoints < 0) {
			throw new ServiceException("用户积分不足");
		}
		userPoints.setCurrentPoints(nowPoints);
		int updateCount = userPointsMapper.updateById(userPoints);
		// 更新积分明细 TODO 未完成
	}

	@Override
	public Integer getUserPoints(Long userId) {
		return null;
	}
}
