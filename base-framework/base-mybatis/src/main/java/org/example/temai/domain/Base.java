package org.example.temai.domain;


import lombok.Data;

import java.util.Date;

/**
 * @author: hanchaowei
 * @date 2023/10/2
 * @description:
 */
@Data
public class Base {

	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后更新时间
	 */
	private Date updateTime;
	/**
	 * 操作人
	 */
	private String operatorId;

	/**
	 * 是否删除
	 */
	private boolean deletionFlag;

	/**
	 * 删除时间
	 */
	private Date deleteTime;
}
