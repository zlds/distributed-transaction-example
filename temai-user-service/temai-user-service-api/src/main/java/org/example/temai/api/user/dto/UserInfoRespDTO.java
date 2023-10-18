package org.example.temai.api.user.dto;

import lombok.Data;

/**
 * @author: hanchaowei
 * @date 2023/10/15
 * @description:
 */
@Data
public class UserInfoRespDTO {

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 用户昵称
	 */
	private String nickName;

	/**
	 * 手机号
	 */
	private String phone;

}
