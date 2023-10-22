package org.example.temai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.temai.convert.UserAddressConvert;
import org.example.temai.dao.UserAddressMapper;
import org.example.temai.domain.UserAddress;
import org.example.temai.vo.UserAddressReq;
import org.example.temai.service.IUserAddressService;
import org.example.temai.vo.UserAddressResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/10/15
 * @description:
 */
@Service
public class IUserAddressServiceImpl implements IUserAddressService {

	@Autowired
	private UserAddressMapper userAddressMapper;

	@Override
	public List<UserAddress> getAddressListByUserId(Long userId) {
		QueryWrapper<UserAddress> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", userId);
		return userAddressMapper.selectList(queryWrapper);
	}


	@Override
	public void addAddress(UserAddressReq req) {
		UserAddress userAddress = UserAddressConvert.convertToEntity(req);
		userAddressMapper.insert(userAddress);
	}

	@Override
	public void updateAddress(UserAddressReq req) {
		UserAddress userAddress = UserAddressConvert.convertToEntity(req);
		userAddressMapper.updateById(userAddress);
	}

	@Override
	public void deleteAddress(Long id) {
		userAddressMapper.deleteById(id);
	}

	@Override
	public UserAddressResp getDefaultAddress(Long userId) {

		QueryWrapper<UserAddress> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", userId);
		queryWrapper.eq("is_default", 1);
		UserAddress userAddress = userAddressMapper.selectOne(queryWrapper);
		return UserAddressConvert.convertToResp(userAddress);
	}

	@Override
	public UserAddress getAddressById(Long addressId) {
		QueryWrapper<UserAddress> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("id", addressId);
		return userAddressMapper.selectOne(queryWrapper);
	}
}
