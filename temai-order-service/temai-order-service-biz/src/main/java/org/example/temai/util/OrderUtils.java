package org.example.temai.util;

import org.example.temai.dao.OrderSequenceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: hanchaowei
 * @date 2023/11/26
 * @description: 订单工具类
 */

public class OrderUtils {


	/**
	 * 生成订单流水号
	 * @return
	 */
	public synchronized static String generateOrderNumber(OrderSequenceMapper orderSequenceMapper) {
		// 获取当前时间
		String timestamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
		// 获取当前序列号
		Long currentSequence = orderSequenceMapper.getCurrentSequence();
		// 拼接成订单流水号
		String orderNumber = timestamp + String.format("%05d", currentSequence);
		// 更新序列号
		orderSequenceMapper.updateSequence(currentSequence + 1);
		return orderNumber;
	}
}
