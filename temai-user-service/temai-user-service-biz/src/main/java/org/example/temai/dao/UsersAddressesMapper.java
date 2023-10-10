package org.example.temai.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.temai.domain.UserAddress;

/**
 * @author: hanchaowei
 * @date 2023/10/5
 * @description:
 */
@Mapper
public interface UsersAddressesMapper extends BaseMapper<UserAddress> {
}
