package com.tuanche.common.constant;

/**
 * 常量类
 * @author 梁晓东
 *
 */
public final class Constant {
	/**
	 * 字符集
	 * @author 梁晓东
	 *
	 */
	public final class Charset {
		/** 字符集 ISO-8859 */
		public static final String ISO_8859 = "ISO-8859";
		/** 字符集 ISO-8859-1 */
		public static final String ISO_8859_1 = "ISO-8859-1";
		/** 字符集 ISO8859-2 */
		public static final String ISO_8859_2 = "ISO-8859-2";
		/** 字符集 GBK */
		public static final String GBK = "GBK";
		/** 字符集 BIG5 */
		public static final String BIG5 = "BIG5";
		/** 字符集 GB2312 */
		public static final String GB2312 = "GB2312";
		/** 字符集 GB18030 */
		public static final String GB18030 = "GB18030";
		/** 字符集 UTF-8 */
		public static final String UTF8 = "UTF-8";
	}
	
	/**
	 * 正则表达式
	 * @author 梁晓东
	 *
	 */
	public final class RegularExpression{
		/** 手机号正则    */
		public static final String mobileReg = "^1\\d{10}$";
		/** email正则    */
		public static final String emailReg = "^[a-zA-Z0-9_\\-]{1,}@[a-zA-Z0-9_\\-]{1,}\\.[a-zA-Z0-9_\\-.]{1,}$";
		/** IP正则    */
		public static final String ipReg = "^((2[0-4]\\d)|(25[0-5])|(1\\d{2})|([1-9]\\d)|(\\d))\\.((2[0-4]\\d)|(25[0-5])|(1\\d{2})|([1-9]\\d)|(\\d))\\.((2[0-4]\\d)|(25[0-5])|(1\\d{2})|([1-9]\\d)|(\\d))\\.((2[0-4]\\d)|(25[0-5])|(1\\d{2})|([1-9]\\d)|(\\d))$";
	}
}
