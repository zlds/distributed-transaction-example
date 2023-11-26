package org.example.temai.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.temai.domain.OrderSequence;

/**
 * @author: hanchaowei
 * @date 2023/11/26
 * @description:
 */
@Mapper
public interface OrderSequenceMapper extends BaseMapper<OrderSequence> {

	/**
	 * 获取当前序列号
	 * @return
	 */
	@Select("select next_id from order_sequence where name = 'order_number'")
	Long getCurrentSequence();

	/**
	 * 更新序列号
	 * @param nextId
	 */
	@Select("update order_sequence set next_id = #{nextId} where id = 'order_number'")
	void updateSequence(Long nextId);
}
