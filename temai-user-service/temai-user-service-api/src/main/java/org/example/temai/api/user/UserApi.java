package org.example.temai.api.user;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.example.temai.api.user.dto.UserAddressRespDTO;
import org.example.temai.api.user.dto.UserInfoRespDTO;
import org.example.temai.framework.common.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/10/15
 * @description:
 */
@RestController
@FeignClient(name = "temai-user-service")
public interface UserApi {

	String PREFIX = "temai-user-service" + "/user";


	/**
	 * 根据userId获取用户信息
	 * @param userId
	 * @return
	 */
	@GetMapping(PREFIX + "/getUserInfoById")
	@ApiOperation("根据userId查询昵称")
	@ApiImplicitParam(name = "userId", value = "用户id", example = "100", required = true)
	CommonResult<UserInfoRespDTO> getUserInfoById(@RequestParam("userId") Long userId);


	/**
	 * 根据userId获取用户地址
	 * @param userId
	 * @return
	 */
	@GetMapping(PREFIX + "/getAddressByUserId")
	@ApiOperation("根据userId查询地址")
	@ApiImplicitParam(name = "userId", value = "用户id", example = "100", required = true)
	CommonResult<List<UserAddressRespDTO>> getAddressByUserId(@RequestParam("userId") Long userId);

	/**
	 * 根据地址id获取地址信息
	 * @param addressId
	 * @return
	 */
	@GetMapping(PREFIX + "/getAddressInfoById")
	@ApiOperation("根据地址id获取地址信息")
	@ApiImplicitParam(name = "addressId", value = "100", example = "100", required = true)
	CommonResult<UserAddressRespDTO> getAddressInfoById(@RequestParam("addressId") Long addressId);

}
