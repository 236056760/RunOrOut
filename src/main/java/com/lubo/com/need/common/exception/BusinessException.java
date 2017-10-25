package com.lubo.com.need.common.exception;

/**
 * 
 * @author liangyuyang
 * @date 2015年11月10日下午4:35:52
 * @description 自定义处理类
 * @version 1.0
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		super(createFriendErrMsg(message));
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	private static String createFriendErrMsg(String message) {
		String prefixStr = "抱歉，";
		String suffixStr = "，请稍后再试或与管理员联系！";
		StringBuffer friendlyErrMsg = new StringBuffer();
		friendlyErrMsg.append(prefixStr).append(message).append(suffixStr);
		return friendlyErrMsg.toString();
	}
}
