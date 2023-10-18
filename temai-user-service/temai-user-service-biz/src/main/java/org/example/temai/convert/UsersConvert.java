package org.example.temai.convert;

import org.example.temai.api.user.dto.UserInfoRespDTO;
import org.example.temai.vo.UserReq;
import org.example.temai.domain.User;
import org.example.temai.framework.common.util.SnowflakeIdUtils;

/**
 * @author: hanchaowei
 * @date 2023/10/6
 * @description:
 */

public class UsersConvert {

	public static User convert(UserReq userReq) {
		User user = new User();
		user.setId(SnowflakeIdUtils.nextId());
		user.setUsername(userReq.getUsername());
		user.setRealName(userReq.getRealName());
		user.setGender(userReq.getGender());
		user.setEmail(userReq.getEmail());
		user.setPhone(userReq.getPhone());
		user.setBirthdate(userReq.getBirthdate());
		return user;
	}

	public static UserInfoRespDTO convertDTO(User user) {
		UserInfoRespDTO userInfoRespDTO = new UserInfoRespDTO();
		userInfoRespDTO.setUserId(user.getId());
		userInfoRespDTO.setUsername(user.getUsername());
		userInfoRespDTO.setNickName(user.getUsername());
		userInfoRespDTO.setPhone(user.getPhone());
		return userInfoRespDTO;
	}
}
