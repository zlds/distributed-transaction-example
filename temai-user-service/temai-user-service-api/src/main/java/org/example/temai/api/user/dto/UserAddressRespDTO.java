package org.example.temai.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: hanchaowei
 * @date 2023/10/18
 * @description: 用户地址返回DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class UserAddressRespDTO {

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
}
