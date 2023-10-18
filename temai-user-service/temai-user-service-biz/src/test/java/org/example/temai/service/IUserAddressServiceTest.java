package org.example.temai.service;

import org.example.temai.vo.UserAddressReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IUserAddressServiceTest {
	@Autowired
	private IUserAddressService iUserAddressService;

	@Test
	void getAddressByUserId() {
	}

	/**
	 * 创建地址
	 */
	@Test
	void addAddress() {
		UserAddressReq req = UserAddressReq.builder()
				.recipientName("张三")
				.phone("18911111111")
				.province("浙江省")
				.city("杭州市")
				.streetAddress("北山街道")
				.district("西湖区")
				.postalCode("310012")
				.isDefault(true)
				.build();
		iUserAddressService.addAddress(req);
	}

	@Test
	void updateAddress() {
		UserAddressReq req = new UserAddressReq();
		req.setIsDefault(false);
		iUserAddressService.updateAddress(req);
	}

	@Test
	void deleteAddress() {
		iUserAddressService.deleteAddress(1L);
	}

	@Test
	void getDefaultAddress() {
		iUserAddressService.getDefaultAddress(1L);
	}
}