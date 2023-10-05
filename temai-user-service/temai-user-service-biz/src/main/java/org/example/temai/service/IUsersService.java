package org.example.temai.service;

import org.example.temai.controller.vo.UsersInfoVO;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/10/4
 * @description:
 */

public interface IUsersService {
	/**
	 * 查询用户列表
	 * @return
	 */
	List<UsersInfoVO> listUsers();
}
