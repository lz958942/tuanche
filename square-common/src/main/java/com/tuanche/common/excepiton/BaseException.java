package com.tuanche.common.excepiton;

/**
 * 自定义异常类的基类
 * 
 * @author 梁晓东
 *
 */
public abstract class BaseException extends Exception {
	private static final long serialVersionUID = 1L;

	private String errCode;// 错误码
	private String errMsg;// 错误信息

	/**
	 * 构造器
	 */
	public BaseException() {
		super();
	}

	/**
	 * 自定义异常
	 * 
	 * @param errMsg
	 */
	public BaseException(String errMsg) {
		super();
		this.errMsg = errMsg;
	}

	/**
	 * 构造器
	 * 
	 * @param errMsg
	 *            异常信息
	 * @param cause
	 *            异常堆栈信息
	 */
	public BaseException(String errMsg, Throwable cause) {
		super(cause);
		this.errMsg = errMsg;
	}

	/**
	 * 构造器
	 * 
	 * @param errCode
	 *            错误码
	 * @param errMsg
	 *            异常信息
	 * @param cause
	 *            异常堆栈信息
	 */
	public BaseException(String errMsg, Throwable cause, String errCode) {
		super(cause);
		this.errMsg = errMsg;
		this.errCode = errCode;
	}

	/**
	 * 自定义异常
	 * 
	 * @param cause
	 */
	public BaseException(Throwable cause) {
		super(cause);
	}

	public String geterrCode() {
		return errCode;
	}

	public void seterrCode(String errCode) {
		this.errCode = errCode;
	}

	public String geterrMsg() {
		return errMsg;
	}

	public void seterrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
