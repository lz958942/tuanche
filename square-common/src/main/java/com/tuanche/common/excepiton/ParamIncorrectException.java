package com.tuanche.common.excepiton;

/**
 * 参数错误异常
 * @author 梁晓东
 *
 */
public class ParamIncorrectException extends BaseException {
	private static final long serialVersionUID = 1L;

	/**
	 * 构造器
	 */
	public ParamIncorrectException() {
		super();
	}

	/**
	 * 构造器
	 * 
	 * @param errMsg
	 */
	public ParamIncorrectException(String errMsg) {
		super(errMsg);
	}

	/**
	 * 构造器
	 * 
	 * @param errMsg
	 *            异常详细信息
	 * @param cause
	 *            异常原因
	 */
	public ParamIncorrectException(String errMsg, Throwable cause) {
		super(errMsg, cause);
	}

	/**
	 * 构造器
	 * 
	 * @param errMsg
	 *            异常详细信息
	 */
	public ParamIncorrectException(String errMsg, Throwable cause, String errCode) {
		super(errMsg, cause, errCode);
	}

	/**
	 * 构造器
	 * 
	 * @param cause
	 */
	public ParamIncorrectException(Throwable cause) {
		super(cause);
	}
}
