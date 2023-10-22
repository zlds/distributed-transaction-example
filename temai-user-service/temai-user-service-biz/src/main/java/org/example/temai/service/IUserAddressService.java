package org.example.temai.service;

import org.example.temai.domain.UserAddress;
import org.example.temai.vo.UserAddressReq;
import org.example.temai.vo.UserAddressResp;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/10/15
 * @description: 用户地址服务
 */

public interface IUserAddressService {

	/**
	 * 根据userId获取用户地址列表
	 * @param userId
	 * @return
	 */
	List<UserAddress> getAddressListByUserId(Long userId);

	/**
	 * 新增用户地址
	 * @param req
	 */
	void addAddress(UserAddressReq req);

	/**
	 * 修改用户地址
	 * @param req
	 */
	void updateAddress(UserAddressReq req);

	/**
	 * 删除用户地址
	 * @param id
	 */
	void deleteAddress(Long id);

	/**
	 * 获取用户默认地址
	 * @param userId
	 * @return
	 */
	UserAddressResp getDefaultAddress(Long userId);

	/**
	 * 根据id获取地址
	 * @param addressId
	 * @return
	 */
	UserAddress getAddressById(Long addressId);
}
