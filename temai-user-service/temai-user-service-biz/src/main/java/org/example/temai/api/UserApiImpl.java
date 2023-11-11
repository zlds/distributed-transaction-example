package org.example.temai.api;

import org.example.temai.api.user.UserApi;
import org.example.temai.api.user.dto.UserAddressRespDTO;
import org.example.temai.api.user.dto.UserInfoRespDTO;
import org.example.temai.convert.UserAddressConvert;
import org.example.temai.domain.UserAddress;
import org.example.temai.framework.common.pojo.CommonResult;
import org.example.temai.service.IUserAddressService;
import org.example.temai.service.IUserService;
import org.example.temai.vo.UserAddressResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: hanchaowei
 * @date 2023/10/18
 * @description:
 */
@RestController
public class UserApiImpl implements UserApi {

	@Autowired
	private IUserService iUserService;

	@Autowired
	private IUserAddressService iUserAddressService;

	@Override
	public CommonResult<UserInfoRespDTO> getUserInfoById(Long userId) {
		UserInfoRespDTO userDTO = iUserService.getUserById(userId);
		return CommonResult.success(userDTO);
	}

	@Override
	public CommonResult<List<UserAddressRespDTO>> getAddressByUserId(Long userId) {
		List<UserAddress> userAddressList = iUserAddressService.getAddressListByUserId(userId);
		List<UserAddressRespDTO> userAddressRespDTOList = userAddressList.stream()
				.map(UserAddressConvert::convertToRespDTO)
				.collect(Collectors.toList());
		return CommonResult.success(userAddressRespDTOList);
	}


	@Override
	public CommonResult<UserAddressRespDTO> getAddressInfoById(Long addressId) {
		UserAddress address = iUserAddressService.getAddressById(addressId);
		return CommonResult.success(UserAddressConvert.convertToRespDTO(address));
	}
}
