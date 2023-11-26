package org.example.temai.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.temai.domain.OrderDetail;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/10/24
 * @description:
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

	/**
	 * 批量插入订单详情
	 * @param orderDetailList
	 */
	void batchInsert(List<OrderDetail> orderDetailList);
}
