package org.example.temai.framework.common.exception.enums;

import org.example.temai.framework.common.exception.ErrorCode;

/**
 * @author: hanchaowei
 * @date 2023/10/23
 * @description:
 */

public interface ErrorCodeConstants {

	/**
	 * 参数错误
	 */
	ErrorCode PARAM_ERROR = new ErrorCode(10000, "参数错误");


	/**
	 * 用户地址不存在
	 */
	ErrorCode ADDRESS_NOT_EXIST = new ErrorCode(20000, "用户地址不存在");
}
