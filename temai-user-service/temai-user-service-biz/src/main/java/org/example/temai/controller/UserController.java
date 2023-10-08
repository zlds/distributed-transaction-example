package org.example.temai.controller;

import org.example.temai.controller.vo.UserReq;
import org.example.temai.framework.common.pojo.CommonResult;
import org.example.temai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.temai.framework.common.pojo.CommonResult.success;

/**
 * @author: hanchaowei
 * @date 2023/10/6
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService iUserService;

	/**
	 * 添加用户
	 * @param userReq
	 * @return
	 */
	@GetMapping("/add")
	public CommonResult<String> addUser(@RequestBody UserReq userReq) {
		iUserService.addUser(userReq);
		return success("成功");
	}
}
