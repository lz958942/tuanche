package com.tuanche.common.dateUtil;

import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DateSimpleFormUtil {
		
	private static String yyyymmddPattern = "yyyy-MM-dd";
	
	private static String yyyymmddhhmmssPattern = "yyyy-MM-dd HH:mm:ss";
	
	private static String yyyymmddChinesePattern = "yyyy年 MM月 dd日";
	
	private static final ConcurrentMap<String, SimpleDateFormat> timestampFormatPool = new  ConcurrentHashMap<String, SimpleDateFormat>();
	
	private static final ConcurrentMap<String, SimpleDateFormat> dateFormatPool = new ConcurrentHashMap<String, SimpleDateFormat>();
	
	private static final ConcurrentMap<String, SimpleDateFormat> strFormatPool = new ConcurrentHashMap<String, SimpleDateFormat>();

	
	/**
	 * 获取自定义时间格式类  yyyy-MM-dd
	 * @return
	 */
	public static SimpleDateFormat getDateFormatYYYYMMDD() {
		SimpleDateFormat tl = dateFormatPool.get(yyyymmddPattern);
		if (null == tl) {
			tl =  new SimpleDateFormat(yyyymmddPattern);
			dateFormatPool.put(yyyymmddPattern, tl);
		}
		return tl;
	}
	

	/**
	 * 获取自定义时间格式类  yyyy年 MM月 dd日
	 * @return
	 */
	public static SimpleDateFormat getStrFormatYYYYMMDDChinese() {
		SimpleDateFormat tl = strFormatPool.get(yyyymmddChinesePattern);
		if (null == tl) {
			tl = new SimpleDateFormat(yyyymmddChinesePattern); 
			strFormatPool.put(yyyymmddChinesePattern, tl);
		}
		return tl;
	}

	
	/**
	 * 获取自定义时间格式类 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static SimpleDateFormat getTimestampFormatYYYYMMDDHHMMSS() {
		SimpleDateFormat tl = timestampFormatPool.get(yyyymmddhhmmssPattern);
		if (null == tl) {
			tl = new SimpleDateFormat(yyyymmddhhmmssPattern);
			timestampFormatPool.put(yyyymmddhhmmssPattern, tl);
		}
		return tl;
	}

}
