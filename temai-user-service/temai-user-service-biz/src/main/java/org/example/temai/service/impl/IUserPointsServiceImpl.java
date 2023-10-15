package org.example.temai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.temai.dao.UserPointDetailMapper;
import org.example.temai.dao.UserPointMapper;
import org.example.temai.domain.UserPointDetail;
import org.example.temai.domain.UserPoint;
import org.example.temai.framework.common.enums.PointEnum;
import org.example.temai.framework.common.exception.ServiceException;
import org.example.temai.framework.common.util.SnowflakeIdUtils;
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
	private UserPointMapper userPointMapper;
	@Autowired
	private UserPointDetailMapper userPointDetailMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addUserPoints(Long userId, Integer points, Long transactionId, Integer pointType) {
		// 查询用户积分
		QueryWrapper<UserPoint> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", userId);
		UserPoint userPoints = userPointMapper.selectOne(queryWrapper);

		// 如果是订单类型积分，判断是否已经完成支付。
		if (pointType.equals(PointEnum.ORDER.getType())) {
			// 查询订单支付已经支付
			// TODO 未完成
		}


		// 添加积分
		UserPoint userPoint = new UserPoint();
		userPoint.setId(SnowflakeIdUtils.nextId());
		userPoint.setUserId(userId);
		userPoint.setCurrentPoint(points);
		userPointMapper.insert(userPoint);
		// 添加积分明细
		UserPointDetail userPointDetail = new UserPointDetail();
		userPointDetail.setUserPointId(userPoint.getId());
		userPointDetail.setUserId(userId);
		userPointDetail.setPointType(pointType);
		userPointDetail.setChangeAmount(points);
		userPointDetail.setTransactionId(transactionId);
		userPointDetailMapper.insert(userPointDetail);
	}

	@Override
	public void subtractUserPoints(Long userId, Integer points, Long transactionId, Integer pointType) {
		// 查询用户积分
		QueryWrapper<UserPoint> queryWrapper2 = new QueryWrapper<>();
		queryWrapper2.eq("user_id", userId);
		UserPoint userPoint = userPointMapper.selectOne(queryWrapper2);
		if (userPoint == null) {
			throw new ServiceException("用户积分不存在");
		}
		// 查询积分明细，如果存在表示已经处理过了。 TODO 未完成
		QueryWrapper<UserPoint> queryWrapper1 = new QueryWrapper<>();
		queryWrapper1.eq("transaction_id", transactionId);
		queryWrapper1.eq("user_points_id", userPoint.getId());
		queryWrapper1.eq("user_id", userId);

		// 更新积分
		Integer currentPoints = userPoint.getCurrentPoint();
		int nowPoints = currentPoints - points;
		if (nowPoints < 0) {
			throw new ServiceException("用户积分不足");
		}
		userPoint.setCurrentPoint(nowPoints);
		int updateCount = userPointMapper.updateById(userPoint);
		// 更新积分明细 TODO 未完成
	}

	@Override
	public Integer getUserPoints(Long userId) {
		QueryWrapper<UserPoint> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", userId);
		UserPoint userPoint = userPointMapper.selectOne(queryWrapper);
		return userPoint.getCurrentPoint();
	}
}
