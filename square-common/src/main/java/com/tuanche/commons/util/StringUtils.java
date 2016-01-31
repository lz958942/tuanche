package com.tuanche.commons.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StringUtils {
	public static boolean isNotEmpty(String str) {
		return (str != null) && (!"".equals(str)) && (!"null".equalsIgnoreCase(str));
	}

	public static boolean isNotEmptyOrZero(String str) {
		return (str != null) && (!"".equals(str)) && (!"null".equalsIgnoreCase(str) && (!"0".equalsIgnoreCase(str)));
	}

	public static int strToInt(String str) {

		try {
			if (isEmpty(str)) {
				return 0;
			}
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0 || str.equalsIgnoreCase(null);
	}

	public static String encodeUTF8(String value) {
		try {
			return URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new InternalException(e);
		}
	}

	public static String decodeUTF8(String value) {
		try {
			return URLDecoder.decode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new InternalException(e);
		}
	}

	public static int strToInt(String str, int defaultValue) {

		try {
			if (isEmpty(str)) {
				return defaultValue;
			}
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	public static boolean isEmptyOrZero(String str) {
		return str == null || str.trim().length() == 0 || str.equalsIgnoreCase(null) || "0".equals(str);
	}

}
