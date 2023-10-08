package org.example.temai.service.impl;

import org.example.temai.controller.vo.UserReq;
import org.example.temai.controller.vo.UsersInfoVO;
import org.example.temai.convert.UsersConvert;
import org.example.temai.dao.UsersMapper;
import org.example.temai.domain.User;
import org.example.temai.service.IUserService;
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
public class IUserServiceImpl implements IUserService {

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public List<UsersInfoVO> listUsers() {
		List<User> users = usersMapper.selectList(null);
		return users.stream().map(s -> convertToUsersInfoVO(s)).collect(Collectors.toList());
	}


	@Override
	public void addUser(UserReq userReq) {
		usersMapper.insert(UsersConvert.convert(userReq));
	}

	@Override
	public void deleteUser(Long id) {
		int result = usersMapper.deleteById(id);
	}

	private UsersInfoVO convertToUsersInfoVO(User user) {
		UsersInfoVO usersInfoVO = new UsersInfoVO();
		usersInfoVO.setId(user.getId());
		usersInfoVO.setUsername(user.getUsername());
		return usersInfoVO;
	}
}
