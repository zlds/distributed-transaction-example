package org.example.temai.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.temai.domain.Users;

/**
 * @author: hanchaowei
 * @date 2023/10/4
 * @description:
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {
}
