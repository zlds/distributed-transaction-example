package org.example.temai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: hanchaowei
 * @date 2023/10/2
 * @description:
 */
@TableName(value = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Users extends Base {

	/**
	 * 用户id
	 */
	private Long id;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 生日
	 */
	private Date birthdate;

	/**
	 * 头像
	 */
	private String profilePicture;

	/**
	 * 注册时间
	 */
	private Date registrationDate;

	/**
	 * 最后登录时间
	 */
	private Date lastLoginDate;

	/**
	 * 最后登录ip
	 */
	private String lastLoginIp;

	/**
	 * 状态
	 */
	private String status;


}
