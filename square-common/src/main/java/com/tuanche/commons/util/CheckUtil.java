package com.tuanche.commons.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;

import com.tuanche.common.constant.Charset;
import com.tuanche.common.constant.Constant;

/**
 * 参数校验
 * 
 * @author 梁晓东
 *
 */
public class CheckUtil {
	/**
	 * 是否是合法手机号
	 * 
	 * @author 梁晓东
	 * @param mobile
	 * @return true: 合法; false:非法.
	 */
	public static boolean isValidateMobile(String mobile) {
		if (null == mobile) {
			return false;
		} else {
			return mobile.matches(Constant.mobileReg);
		}
	}

	/**
	 * 是否是合法电子邮箱
	 * 
	 * @author 梁晓东
	 * @param email
	 * @return true: 合法; false:非法.
	 */
	public static boolean isValidateEmail(String email) {
		if (null == email) {
			return false;
		} else {
			return email.matches(Constant.emailReg);
		}
	}

	/**
	 * 是否是合法IP
	 * 
	 * @author 梁晓东
	 * @param ip
	 * @return true: 合法; false:非法.
	 */
	public static boolean isValidateIp(String ip) {
		if (null == ip) {
			return false;
		} else {
			return ip.matches(Constant.ipReg);
		}
	}

	/**
	 * 检查JAVA对象是否为空
	 * 
	 * @author 梁晓东
	 * @param obj 待检测的对象
	 * @return true: 空; false:非空.
	 */
	public static boolean checkObjectIsNull(final Object obj) {
		if (obj instanceof String) {
			return checkStringIsNull((String) obj);
		}
		return obj == null;
	}

	/**
	 * 检测Java对象是否为空. 同时检测多个指定的对象, 如果存在一个为空, 则全部为空.
	 * 
	 * @author 梁晓东
	 * @param objs 待检测的对象
	 * @return true: 空; false:非空.
	 */
	public static boolean checkVariableObjectArrayIsNull(final Object... objs) {
		for (final Object obj : objs) {
			final boolean nun = checkObjectIsNull(obj);
			if (nun) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 检测Java对象是否为空. 同时检测多个指定的对象, 如果存在一个为空, 则全部为空.
	 * 
	 * @author 梁晓东
	 * @param objs 待检测的对象
	 * @return true: 空; false:非空.
	 */
	public static boolean CheckObjectArrayIsNull(final Object[] objs) {
		if ((objs == null) || (objs.length == 0)) {
			return true;
		}
		for (final Object obj : objs) {
			final boolean nun = checkObjectIsNull(obj);
			if (nun) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 检查String字符串是否为空
	 * 
	 * @author 梁晓东
	 * @param str
	 * @return true: 空; false:非空.
	 */
	public static boolean checkStringIsNull(final String str) {
		return (str == null) || (str.trim().length() == 0);
	}

	/**
	 * 严格的检测字符串是否为空:1.内存为分配 ; 2.长度为0; 3.参数本身为'null'的字符串
	 * @author 梁晓东
	 * @param str
	 * @return true: 空; false:非空.
	 */
	public static boolean checkStringIsNullStrictly(final String str) {
		return checkStringIsNull(str) || "null".equalsIgnoreCase(str);
	}
	
	/**
	 * 判断集合是否为空
	 * @author 梁晓东
	 * @param colls
	 * @return true: 空; false:非空.
	 */
	public static boolean checkCollectionIsNullOrEmpty(final Collection<?> colls) {
		return (colls == null) || colls.isEmpty();
	}

	/**
	 * 判断Map集合是否为空
	 * @author 梁晓东
	 * @param map
	 * @return true: 空; false:非空.
	 */
	public static boolean checkMapIsNullOrEmpty(final Map<?, ?> map) {
		return (map == null) || map.isEmpty();
	}
	
	/**
	 * 对参数用UTF-8编码
	 * @author 梁晓东
	 * @param params
	 * @return
	 */
	public static String encodeUrlWithUTF8(final String params) {
		return encodeUrl(params, Charset.UTF8);
	}
	
	/**
	 * 用指定参数对参数进行编码(如果所传编码格式不支持则用UTF-8进行编码)
	 * @author 梁晓东
	 * @param params 待编码的值
	 * @param encode 编码格式
	 * @return
	 */
	public static String encodeUrl(final String params, final String encode) {
		try {
			return URLEncoder.encode(params, encode);
		} catch (final UnsupportedEncodingException e) {
			return encodeUrl(params, Charset.UTF8);
		}
	}

}
