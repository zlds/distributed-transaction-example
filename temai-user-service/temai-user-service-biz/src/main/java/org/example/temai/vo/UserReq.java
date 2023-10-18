package org.example.temai.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author: hanchaowei
 * @date 2023/10/6
 * @description:
 */
@Data
public class UserReq {

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 用户真实姓名
	 */
	private String realName;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 生日
	 */
	private Date birthdate;
}
