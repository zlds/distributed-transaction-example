package org.example.temai.framework.common.exception;

import lombok.Data;

/**
 * @author: hanchaowei
 * @date 2023/10/23
 * @description: 错误码对象
 */
@Data
public class ErrorCode {

	/**
	 * 错误码
	 */
	private final Integer code;
	/**
	 * 错误提示
	 */
	private final String msg;

	public ErrorCode(Integer code, String message) {
		this.code = code;
		this.msg = message;
	}

}
