package org.example.temai.service;

import org.example.temai.controller.vo.UserReq;
import org.example.temai.controller.vo.UsersInfoVO;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/10/4
 * @description:
 */

public interface IUserService {

	/**
	 * 查询用户列表
	 * @return
	 */
	List<UsersInfoVO> listUsers();

	/**
	 * 添加用户
	 * @param userReq
	 */
	void addUser(UserReq userReq);

	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(Long id);


}
