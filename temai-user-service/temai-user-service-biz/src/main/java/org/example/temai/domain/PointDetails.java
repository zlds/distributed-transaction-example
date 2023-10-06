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
@TableName(value = "point_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class PointDetails extends Base {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 变更日期
	 */
	private String changeDate;

	/**
	 * 变更积分
	 */
	private Integer changeAmount;

	/**
	 * 变更原因
	 */
	private String reason;
}
