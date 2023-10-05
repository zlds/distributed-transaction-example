package org.example.temai.service.impl;

import org.example.temai.controller.vo.UsersInfoVO;
import org.example.temai.dao.UsersMapper;
import org.example.temai.domain.Users;
import org.example.temai.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: hanchaowei
 * @date 2023/10/5
 * @description:
 */
@Service
public class IUsersServiceImpl implements IUsersService {

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public List<UsersInfoVO> listUsers() {
		List<Users> users = usersMapper.selectList(null);
		return users.stream().map(s -> convertToUsersInfoVO(s)).collect(Collectors.toList());
	}

	private UsersInfoVO convertToUsersInfoVO(Users users) {
		UsersInfoVO usersInfoVO = new UsersInfoVO();
		usersInfoVO.setId(users.getId());
		usersInfoVO.setUsername(users.getUsername());
		return usersInfoVO;
	}
}
