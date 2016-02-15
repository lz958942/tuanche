package com.tuanche.commons.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * String类型工具类，包括是否为空、字符串转型[byte/byte数组/long/int]/查找、截取
 * 
 * @author zhangpeng
 * @Date 2016-01-30
 */
public class StringUtils {
	/**
	 * 判断是否不为空
	 */
	public static boolean isNotEmpty(String str) {
		return (str != null) && (!"".equals(str)) && (!"null".equalsIgnoreCase(str));
	}

	/**
	 * 判断是否不为空或者不为字符串0
	 */
	public static boolean isNotEmptyOrZero(String str) {
		return (str != null) && (!"".equals(str)) && (!"null".equalsIgnoreCase(str) && (!"0".equalsIgnoreCase(str)));
	}

	/**
	 * String类型转成int类型
	 */
	public static int strToInt(String str) {

		try {
			if (isEmpty(str)) {
				return 0;
			}
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * String类型转成long类型
	 */
	public static long strToLong(String str) {

		try {
			if (isEmpty(str)) {
				return 0l;
			}
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0l;
		}
	}

	/**
	 * String类型转成double类型
	 */
	public static double strToDouble(String str) {

		try {
			if (isEmpty(str)) {
				return 0d;
			}
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0d;
		}
	}

	/**
	 * 字符串转成btye数组,用默认编码
	 */
	public static byte[] strToByte(String value) throws Exception {
		try {
			return value.getBytes();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 字符串转成btye数组,用默认编码
	 */
	public static byte[] strToByte(String value, String encode) throws Exception {
		try {
			return value.getBytes(encode);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 判断字符串是否为null
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0 || str.equalsIgnoreCase(null);
	}

	/**
	 * 字符串utf-8转码
	 */
	public static String encodeUTF8(String value) throws Exception {
		try {
			return URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw e;
		}
	}

	/**
	 * 字符串utf-8解码
	 */
	public static String decodeUTF8(String value) throws Exception {
		try {
			return URLDecoder.decode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw e;
		}
	}

	/**
	 * String类型转成int类型，如果String为空就返回默认值
	 */
	public static int strToInt(String str, int defaultValue) {

		try {
			if (isEmpty(str)) {
				return defaultValue;
			}
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return defaultValue;
		}
	}

	/**
	 * 判断String类型为空或者为null或者值是0的字符串
	 */
	public static boolean isEmptyOrZero(String str) {
		return str == null || str.trim().length() == 0 || str.equalsIgnoreCase(null) || "0".equals(str);

	}

	/**
	 * 字符串查找
	 */
	public static boolean isHave(String[] strs, String s) {
		/*
		 * 此方法有两个参数，第一个是要查找的字符串数组，第二个是要查找的字符或字符串
		 */
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].indexOf(s) != -1) {// 循环查找字符串数组中的每个字符串中是否包含所有查找的内容
				return true;// 查找到了就返回真，不在继续查询
			}
		}
		return false;// 没找到返回false
	}

	/**
	 * 字符串截取，从左边截取 index个字符
	 * 
	 */
	public static String leftSubString(String str, int index) {
		if (isEmpty(str)) {
			return "";
		}
		return str.substring(0, index);
	}

	/**
	 * 字符串截取，从右边边截取 index个字符
	 * 
	 */
	public static String rightSubString(String str, int index) {
		if (isEmpty(str)||index>str.length()) {
			return "";
		}
		return str.substring(str.length() - index, str.length());
	}
}
