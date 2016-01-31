package com.tuanche.common.dateUtil;

import java.text.ParseException;
import java.util.Date;


/**
 * <p>日期工具类</p>
 * 
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * <PRE>
 * 
 * @author wanghl
 * @since 1.0
 * @version 1.0
 * @from afi
 */ 

public class DateCommonUtil extends DateSimpleFormUtil{

	public enum IntervalUnit {
		MILLISECOND, SECOND, MINUTE, HOUR, DAY, WEEK, MONTH, YEAR
	}

	/**
	 * 格式化成时间戳格式
	 * @author afi
	 * @param date	要格式化的日期
	 * @return	"年年年年-月月-日日 时时:分分:秒秒"格式的日期字符串
	 */
	public static String timestampFormatYYYYMMDDHHMMSS(final Date date) {
		if (date == null) {
			return "";
		}
		return getTimestampFormatYYYYMMDDHHMMSS().format(date);
	}
	/**
	 * 格式化成日期格式
	 * @author afi
	 * @param date	要格式化的日期
	 * @return	"年年年年-月月-日日"格式的日期字符串
	 */
	public static String dateFormatYYYYMMDDD(final Date date) {
		if (date == null) {
			return "";
		}
		return getDateFormatYYYYMMDD().format(date);
	}
	
	
	
	
	
	/**
	 * 格式化成时间戳格式
	 * @author afi
	 * @param datetime	要格式化的日期
	 * @return	"年年年年-月月-日日 时时:分分:秒秒"格式的日期字符串
	 */
	public static String timestampFormatYYYYMMDDHHMMSS(final long datetime) {
		return getTimestampFormatYYYYMMDDHHMMSS().format(new Date(datetime));
	}
	/**
	 * 格式化成日期格式
	 * @author afi
	 * @param datetime	要格式化的日期
	 * @return	"年年年年-月月-日日"格式的日期字符串
	 */
	public static String dateFormatYYYYMMDDD(final long datetime) {
		return getDateFormatYYYYMMDD().format(new Date(datetime));
	}
	
	
	
	

	
	/**
	 * 将"年年年年-月月-日日 时时:分分:秒秒"格式的日期字符串转换成日期型
	 * @author afi
	 * @param timestampStr	年年年年-月月-日日 时时:分分:秒秒日期字符串
	 * @return	Date型日期
	 */
	public static Date formatTimestampToDateYYYYMMDDHHMMSS(final String timestampStr) {
		Date date;
		try {
			date = getTimestampFormatYYYYMMDDHHMMSS().parse(timestampStr);
		} catch (final ParseException e) {
			return null;
		}
		return date;
	}

	/**
	 * 将"年年年年-月月-日日"格式的日期字符串转换成日期型
	 * @author afi
	 * @param timestampStr	年年年年-月月-日日日期字符串
	 * @return	Date型日期
	 */
	public static Date formatTimestampToDateYYYYMMDD(final String timestampStr) {
		Date date;
		try {
			date = getDateFormatYYYYMMDD().parse(timestampStr);
		} catch (final ParseException e) {
			return null;
		}
		return date;
	}
	
	
	
	
	

	/**
	 * 将"年年年年-月月-日日"格式的日期字符串转换成Long型日期
	 * @author afi
	 * @param dateStr	"年年年年-月月-日日"格式的日期字符串
	 * @return	Long型日期
	 * @throws BusinessException	日期格式化异常
	 */
	public static long formatDateToLongYYYYMMDDD(final String dateStr) {//throws BusinessException {
		Date date = null;
		try {
			date = getDateFormatYYYYMMDD().parse(dateStr);
		} catch (final ParseException e) {
			//throw new BusinessException("将输入内容格式化成日期类型时出错。", e);
		}
		return date.getTime();
	}
	
	
	/**
	 * 将"年年年年-月月-日日 时时:分分:秒秒"格式的日期字符串转换成Long型日期
	 * @author afi
	 * @param timestampStr	年年年年-月月-日日 时时:分分:秒秒"格式的日期字符串
	 * @return	Long型日期
	 */
	public static long formatTimestampToLongYYYYMMDDHHMMSS(final String timestampStr) {
		Date date;
		try {
			date = getTimestampFormatYYYYMMDDHHMMSS().parse(timestampStr);
		} catch (final ParseException e) {
			return 0L;
		}
		return date.getTime();
	}

}
