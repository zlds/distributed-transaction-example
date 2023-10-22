package org.example.temai.convert;

import org.example.temai.api.user.dto.UserAddressRespDTO;
import org.example.temai.domain.UserAddress;
import org.example.temai.vo.UserAddressReq;
import org.example.temai.framework.common.util.SnowflakeIdUtils;
import org.example.temai.vo.UserAddressResp;

/**
 * @author: hanchaowei
 * @date 2023/10/15
 * @description:
 */

public class UserAddressConvert {


	/**
	 * 转换为实体
	 * @param req
	 * @return
	 */
	public static UserAddress convertToEntity(UserAddressReq req) {
		return UserAddress.builder()
				.id(SnowflakeIdUtils.nextId())
				// TODO 临时写死，后续需要从token中获取
				.userId(1L)
				.recipientName(req.getRecipientName())
				.phone(req.getPhone())
				.province(req.getProvince())
				.city(req.getCity())
				.district(req.getDistrict())
				.streetAddress(req.getStreetAddress())
				.postalCode(req.getPostalCode())
				.isDefault(req.getIsDefault())
				.build();
	}

	/**
	 * 转换为响应
	 * @param address
	 * @return
	 */
	public static UserAddressResp convertToResp(UserAddress address) {
		return UserAddressResp.builder()
				.id(address.getId())
				.userId(address.getUserId())
				.recipientName(address.getRecipientName())
				.phone(address.getPhone())
				.province(address.getProvince())
				.city(address.getCity())
				.district(address.getDistrict())
				.streetAddress(address.getStreetAddress())
				.postalCode(address.getPostalCode())
				.build();
	}

	/**
	 * 转换为响应DTO
	 * @param address
	 * @return
	 */
	public static UserAddressRespDTO convertToRespDTO(UserAddress address) {
		return UserAddressRespDTO.builder()
				.recipientName(address.getRecipientName())
				.phone(address.getPhone())
				.province(address.getProvince())
				.city(address.getCity())
				.district(address.getDistrict())
				.streetAddress(address.getStreetAddress())
				.postalCode(address.getPostalCode())
				.build();
	}
}
