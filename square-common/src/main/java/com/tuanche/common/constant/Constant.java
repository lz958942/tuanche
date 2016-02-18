package com.tuanche.common.constant;

/**
 * 常量类
 * @author 梁晓东
 *
 */
public final class Constant {
	/** 手机号正则    */
	public static final String mobileReg = "^1\\d{10}$";
	/** email正则    */
	public static final String emailReg = "^[a-zA-Z0-9_\\-]{1,}@[a-zA-Z0-9_\\-]{1,}\\.[a-zA-Z0-9_\\-.]{1,}$";
	/** IP正则    */
	public static final String ipReg = "^((2[0-4]\\d)|(25[0-5])|(1\\d{2})|([1-9]\\d)|(\\d))\\.((2[0-4]\\d)|(25[0-5])|(1\\d{2})|([1-9]\\d)|(\\d))\\.((2[0-4]\\d)|(25[0-5])|(1\\d{2})|([1-9]\\d)|(\\d))\\.((2[0-4]\\d)|(25[0-5])|(1\\d{2})|([1-9]\\d)|(\\d))$";
}
