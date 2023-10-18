package org.example.temai.service;

import org.example.temai.api.user.dto.UserInfoRespDTO;
import org.example.temai.vo.UserReq;
import org.example.temai.vo.UsersInfoVO;

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

	/**
	 * 根据用户id查询用户信息
	 * @param id
	 * @return
	 */
	UserInfoRespDTO getUserById(Long id);
}
