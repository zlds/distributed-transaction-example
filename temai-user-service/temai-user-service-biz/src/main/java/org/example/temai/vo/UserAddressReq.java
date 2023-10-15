package org.example.temai.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @author: hanchaowei
 * @date 2023/10/15
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class UserAddressReq {

	/**
	 * 收件人姓名
	 */
	@NotBlank(message = "收件人姓名不能为空")
	private String recipientName;

	/**
	 * 联系电话
	 */
	@NotBlank(message = "电话不能为空")
	private String phone;

	/**
	 * 省份
	 */
	@NotBlank(message = "省份不能为空")
	private String province;

	/**
	 * 城市
	 */
	@NotBlank(message = "城市不能为空")
	private String city;

	/**
	 * 区/县
	 */
	@NotBlank(message = "区/县不能为空")
	private String district;

	/**
	 * 街道地址
	 */
	@NotBlank(message = "街道地址不能为空")
	private String streetAddress;

	/**
	 * 邮政编码
	 */
	private String postalCode;

	/**
	 * 是否为默认地址: false-否,true-默认
	 */
	private Boolean isDefault;

}
