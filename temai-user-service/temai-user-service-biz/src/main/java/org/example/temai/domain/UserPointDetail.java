package org.example.temai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: hanchaowei
 * @date 2023/10/6
 * @description: 积分明细
 */
@TableName(value = "user_point_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class UserPointDetail extends Base {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 积分id
	 */
	private Long userPointId;

	/**
	 * 变更日期
	 */
	private String changeDate;

	/**
	 * 变更积分
	 */
	private Integer changeAmount;


	/**
	 * 积分类型(订单,抽奖,签到,活动等,推荐等)
	 */
	private Integer pointType;

	/**
	 * 事件id(唯一性)
	 */
	private Long transactionId;

}
