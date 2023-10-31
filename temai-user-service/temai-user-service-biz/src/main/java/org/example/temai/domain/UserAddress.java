package org.example.temai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * @author: hanchaowei
 * @date 2023/10/5
 * @description: 用户地址
 */
@TableName(value = "user_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class UserAddress extends Base {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 收件人姓名
	 */
	private String recipientName;

	/**
	 * 联系电话
	 */
	private String phone;

	/**
	 * 省份
	 */
	private String province;

	/**
	 * 城市
	 */
	private String city;

	/**
	 * 区/县
	 */
	private String district;

	/**
	 * 街道地址
	 */
	private String streetAddress;

	/**
	 * 邮政编码
	 */
	private String postalCode;

	/**
	 * 是否为默认地址: false-否, true-是
	 */
	private Boolean isDefault;
}
