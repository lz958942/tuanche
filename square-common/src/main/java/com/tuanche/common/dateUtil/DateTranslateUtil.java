package com.tuanche.common.dateUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTranslateUtil extends DateCommonUtil{
	
	public static SimpleDateFormat getSimpleDateFormat(final DateFormatType type) {
		switch (type) {
		case yyyyMMdd:
			return getDateFormatYYYYMMDD();
		case yyyyMMddHHmmss:
			return getTimestampFormatYYYYMMDDHHMMSS();
		case yyyy年MM月dd日:
			return getStrFormatYYYYMMDDChinese();
		default:
			throw new IllegalArgumentException("Unknown IntervalUnit");
		}
	}
	
	public static String getDateToString(final DateStringType type,final Date date) {
		switch (type) {
		case yyyyMMdd:
			return dateFormatYYYYMMDDD(date);
		case yyyyMMddHHmmss:
			return timestampFormatYYYYMMDDHHMMSS(date);
		default:
			throw new IllegalArgumentException("Unknown IntervalUnit");
		}
	}
	
	public static String getLongToDate(final DateStringType type,final long datetime) {
		switch (type) {
		case yyyyMMdd:
			return dateFormatYYYYMMDDD(datetime);
		case yyyyMMddHHmmss:
			return timestampFormatYYYYMMDDHHMMSS(datetime);
		default:
			throw new IllegalArgumentException("Unknown IntervalUnit");
		}
	}
	
	
	
	public static Date getStringToDate(final DateStringType type,final String timestampStr) {
		switch (type) {
		case yyyyMMdd:
			return formatTimestampToDateYYYYMMDD(timestampStr);
		case yyyyMMddHHmmss:
			return formatTimestampToDateYYYYMMDDHHMMSS(timestampStr);
		default:
			throw new IllegalArgumentException("Unknown IntervalUnit");
		}
	}
	
	
	
	public static Long getStringToLong(final DateStringType type,final String timestampStr) {
		switch (type) {
		case yyyyMMdd:
			return formatDateToLongYYYYMMDDD(timestampStr);
		case yyyyMMddHHmmss:
			return formatTimestampToLongYYYYMMDDHHMMSS(timestampStr);
		default:
			throw new IllegalArgumentException("Unknown IntervalUnit");
		}
	}
	
	
	
	
	
	
	/*******************	获取当前日期	********************/
    /**
     * 获取当前的时间
     * @return
     */
    public static Date getNowDate(){
        return  new Date();
    }

    /**
     * 获取当前的时间
     * @return
     */
    public static Timestamp getNowTimestamp(){
        return  new Timestamp(System.currentTimeMillis());
    }
	
    /**
	 * 获取当前时间，精确到秒
	 * @author afi
	 * @return	精确到秒的当前时间
	 */
	public static int currentTimeSecond() {
		return Long.valueOf(System.currentTimeMillis() / 1000).intValue();
	}
    
	
	
	
	
    /*******************	获取月日期	********************/
    /**
	 * 获取指定日期所在月的第一天
	 * @author afi
	 * @param date	日期
	 * @return	以"年年年年-月月-日日"格式返回当指定月第一天的日期
	 */
	public static String getFirstDayOfMonth(final Date date) {
		final Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.DAY_OF_MONTH, 1);
		return getDateFormatYYYYMMDD().format(ca.getTime());
	}
	
	/**
	 * 得到月份第一天.以当前月份为基准
	 * @author afi
	 * @param offset
	 * @return Date
	 */
	public static Date getFirstDayOfMonth(int offset) {
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH,offset);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		return calendar.getTime();
	}
	
	
	/**
	 * 得到本月的第一天
	 * @author afi
	 * @return Date
	 */
	public static Date getFirstDayOfCurrentMonth() {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}
	
	
	

	/**
	 * 获取指定日期所在月的最后一天
	 * @author afi
	 * @param date
	 * @return	以"年年年年-月月-日日"格式返回当指定月最后一天的日期
	 */
	public static Date getLastDayOfMonth(final Date date) {
		final Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.DAY_OF_MONTH, 1);
		ca.roll(Calendar.DAY_OF_MONTH, -1);
		return ca.getTime();
	}
    
	/**
	 * 得到月份最后一天.以当前月份为基准
	 * @author afi
	 * @return	以"年年年年-月月-日日"格式返回当前月最后一天的日期
	 */
	public static Date getLastDayOfMonth(int offset) {
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH,offset);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		return calendar.getTime();
	}

	/**
	 * 得到本月的最后一天
	 * @author afi
	 * @return	以"年年年年-月月-日日"格式返回当前月最后一天的日期
	 */
	public static Date getLastDayOfCurrentMonth() {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}
	
	
	
	/**
	 * 得到下个月的第一秒
	 * @return
	 */
	public static Long getFirstMillSecondOfNextMonth(){
		Date d = getFirstDayOfMonth(1);
		return d.getTime();
	}
	
	/**
	 * 得到下个月的最后一秒
	 * @return
	 */
	public static Long getLastMillSecondOfNextMonth(){
		Date d = getLastDayOfMonth(1);
		return d.getTime()+24*3600*1000L-1000L;
	}
	
	
	
	
	
	
	
	
	
	 /*******************	获取周日期	********************/
	/**
	 * 获取指定日期所在周的第一天
	 * @author afi
	 * @param date	日期
	 * @return	以"年年年年-月月-日日"格式返回当指定周第一天的日期
	 */
	public static Date getFirstDayOfWeek(final Date date) {
		final Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.DAY_OF_WEEK, 2);
		return ca.getTime();
	}
	
	
	/**
	 * 获取当前日期所在周的周末
	 * @param date
	 * @return
	 */
	private static Calendar lastDayOfWeek(final Date date){
		final Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		//日期减去1防止是周日（国外周日为一周的第一天）
		ca.add(Calendar.DATE,-1);
		//设置为本周的周六,这里不能直接设置为周日，中国本周日和国外本周日不同
		ca.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
		//日期往前推移一天
		ca.add(Calendar.DATE,1);
		return ca;
	}
	
	/**
	 * 获取当前日期所在周的周末
	 * @param date
	 * @return
	 */
	private static Date lastToDayOfWeek(final Date date){
		final Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		//日期减去1防止是周日（国外周日为一周的第一天）
		ca.add(Calendar.DATE,-1);
		//设置为本周的周六,这里不能直接设置为周日，中国本周日和国外本周日不同
		ca.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
		//日期往前推移一天
		ca.add(Calendar.DATE,1);
		return ca.getTime();
	}
	
	
	/**
	 * 获取当前日期所在的周六    第一秒
	 * @param date
	 * @return
	 */
	public static Long getSaturdayOfWeek(final Date date) {
		//周日零点零分零秒
		final Calendar ca = lastDayOfWeek(date);
		ca.set(Calendar.HOUR_OF_DAY,0);
		ca.set(Calendar.MINUTE,0);
		ca.set(Calendar.SECOND,0);
		ca.set(Calendar.MILLISECOND,0);
		//日期减去1天 变为周六零时零分零秒
		ca.add(Calendar.DATE,-1);
		return ca.getTime().getTime();
	}
	
	
	/**
	 * 获取当前日期所在的周日    最后一秒
	 * @param date
	 * @return
	 */
	public static Long getLastSecondOfWeek(final Date date) {
		final Calendar ca = lastDayOfWeek(date);
		ca.set(Calendar.HOUR_OF_DAY, 0);
		ca.set(Calendar.MINUTE,0);
		ca.set(Calendar.SECOND,0);
		ca.set(Calendar.MILLISECOND,0);
		ca.add(Calendar.DATE,1);
		return ca.getTime().getTime()-1;
	}
	
	
	
	
	
	
	
	
	 /*******************	获取当前日期相邻日期	********************/

	/**
	 * 获取当前日期几天前或几天后的日期
	 * 
	 * @param day
	 *            可为负数,为负数时代表获取之前的日期.为正数,代表获取之后的日期
	 * @return
	 */
	public static Date getTime(final int day) {
		return getTime(new Date(), day);
	}
	
	
	
	/**
	 * 获取指定日期几天前或几天后的日期
	 * 
	 * @param date
	 *            指定的日期
	 * @param day
	 *            可为负数, 为负数时代表获取之前的日志.为正数,代表获取之后的日期
	 * @return
	 */
	public static Date getTime(final Date date, final int day) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + day);
		return calendar.getTime();
	}
	
	
	/**
	 * 获取指定日期几小时后的时间
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date addTime(final Date date, final int hour) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + hour);
		return calendar.getTime();
	}
	
	
	
	 /*******************	日期字符处理工具	********************/
	/**
	 * 替换掉日期格式中所有分隔符（含“-”、“:”及空格）
	 * @author afi
	 * @param target	字符型目标日期
	 * @return	替换后的结果
	 */
	public static String replaceAllSeparator(final String target) {
		return target.replace("-", "").replace(":", "").replace(" ", "");
	}

	
	
	
	/**
	 * 
	 * 替换掉日志格式中指定的分隔符
	 * @author afi
	 * @param target	字符型目标日期
	 * @param separator	要被替换掉的分割符
	 * @return	替换后的结果
	 */
	public static String replaceSeparator(final String target, final String... separator) {
		String temp = target;
		for (final String sep : separator) {
			temp = temp.replace(sep, "");
		}
		return temp;
	}
	
	
	/**
	 * 
	 * 根据步长获取时间
	 *
	 * @author afi
	 * @param interval 步长 ，正数获取将来时间， 负数获取以前的时间
	 * @param unit 步长单位, 年月周日时分秒
	 * @return
	 */
	public static Date intervalDate(final int interval, final IntervalUnit unit) {
		final Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.setLenient(true);
		c.add(translate(unit), interval);
		return c.getTime();
	}

	
	private static int translate(final IntervalUnit unit) {
		switch (unit) {
		case DAY:
			return Calendar.DAY_OF_YEAR;
		case HOUR:
			return Calendar.HOUR_OF_DAY;
		case MINUTE:
			return Calendar.MINUTE;
		case MONTH:
			return Calendar.MONTH;
		case SECOND:
			return Calendar.SECOND;
		case MILLISECOND:
			return Calendar.MILLISECOND;
		case WEEK:
			return Calendar.WEEK_OF_YEAR;
		case YEAR:
			return Calendar.YEAR;
		default:
			throw new IllegalArgumentException("Unknown IntervalUnit");
		}
	}
	
	
	/**
	 * 功能：判断字符串是否为日期格式
	 *
	 * @param strDate
	 * @return
	 */
	public static boolean isDate(String strDate) {
		Pattern pattern = Pattern.compile(
				"^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		Matcher m = pattern.matcher(strDate);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
}
