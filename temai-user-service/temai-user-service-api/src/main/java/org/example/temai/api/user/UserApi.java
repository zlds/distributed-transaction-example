package org.example.temai.api.user;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.example.temai.api.user.dto.UserAddressRespDTO;
import org.example.temai.api.user.dto.UserInfoRespDTO;
import org.example.temai.framework.common.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/10/15
 * @description:
 */
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
	 */
	@GetMapping(PREFIX + "/getAddressByUserId")
	@ApiOperation("根据userId查询地址")
	@ApiImplicitParam(name = "userId", value = "用户id", example = "100", required = true)
	CommonResult<List<UserAddressRespDTO>> getAddressByUserId(@RequestParam("userId") Long userId);
}
