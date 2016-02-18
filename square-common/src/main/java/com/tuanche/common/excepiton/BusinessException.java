package com.tuanche.common.excepiton;

/**
 * 业务异常类
 * 
 * @author 梁晓东
 *
 */
public class BusinessException extends BaseException {
	private static final long serialVersionUID = 1L;

	/**
	 * 构造器
	 */
	public BusinessException() {
		super();
	}

	/**
	 * 构造器
	 * 
	 * @param errMsg
	 */
	public BusinessException(String errMsg) {
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
	public BusinessException(String errMsg, Throwable cause) {
		super(errMsg, cause);
	}

	/**
	 * 构造器
	 * 
	 * @param errMsg
	 *            异常详细信息
	 */
	public BusinessException(String errMsg, Throwable cause, String errCode) {
		super(errMsg, cause, errCode);
	}

	/**
	 * 构造器
	 * 
	 * @param cause
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}
}
