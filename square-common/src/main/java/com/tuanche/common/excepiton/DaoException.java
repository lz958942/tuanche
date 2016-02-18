package com.tuanche.common.excepiton;

/**
 * 数据库操作异常
 * @author 梁晓东
 *
 */
public class DaoException extends BaseException {
	private static final long serialVersionUID = 1L;


	/**
	 * 构造器
	 */
	public DaoException() {
		super();
	}

	/**
	 * 构造器
	 * 
	 * @param errMsg
	 */
	public DaoException(String errMsg) {
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
	public DaoException(String errMsg, Throwable cause) {
		super(errMsg, cause);
	}

	/**
	 * 构造器
	 * 
	 * @param errMsg
	 *            异常详细信息
	 */
	public DaoException(String errMsg, Throwable cause, String errCode) {
		super(errMsg, cause, errCode);
	}

	/**
	 * 构造器
	 * 
	 * @param cause
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}
}
