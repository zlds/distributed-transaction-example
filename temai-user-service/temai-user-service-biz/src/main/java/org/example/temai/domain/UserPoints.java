package org.example.temai.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: hanchaowei
 * @date 2023/10/6
 * @description: 用户积分
 */

@TableName(value = "user_points")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class UserPoints extends Base {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 当前积分
	 */
	private Integer currentPoints;

	/**
	 * 会员等级
	 */
	private Integer memberLevel;

	/**
	 * 版本
	 */
	@Version
	private Integer version;
}
