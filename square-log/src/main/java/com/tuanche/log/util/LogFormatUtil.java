package com.tuanche.log.util;

import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class LogFormatUtil {

	private static Gson gson = new GsonBuilder().serializeNulls().create();

	/**
	 * debug级别日志
	 * 
	 * @author XieXP
	 * @date 2016年3月1日 下午4:50:30
	 * @param logger
	 *            日志对象
	 * @param logFormat
	 *            日志参数
	 */
	public static void debug(final Logger logger, final Object logFormat) {
		if (logger != null && logger.isDebugEnabled()) {
			logger.debug(LogFormat(logger, logFormat));
		}
	}

	/**
	 * debug级别日志
	 * 
	 * @author XieXP
	 * @date 2016年3月1日 下午4:50:37
	 * @param logger
	 *            日志对象
	 * @param logFormat
	 *            日志参数
	 * @param e
	 *            异常
	 */
	public static void debug(final Logger logger, final Object logFormat, final Throwable e) {
		if (logger != null && logger.isDebugEnabled()) {
			logger.debug(LogFormat(logger, logFormat), e);
		}
	}

	/**
	 * info级别日志
	 * 
	 * @author XieXP
	 * @date 2016年3月1日 下午4:50:46
	 * @param logger
	 *            日志对象
	 * @param logFormat
	 *            日志参数
	 */
	public static void info(final Logger logger, final Object logFormat) {
		if (logger != null && logger.isInfoEnabled()) {
			logger.info(LogFormat(logger, logFormat));
		}
	}

	/**
	 * info级别日志
	 * 
	 * @author XieXP
	 * @date 2016年3月1日 下午4:50:52
	 * @param logger
	 *            日志对象
	 * @param logFormat
	 *            日志参数
	 * @param e
	 *            异常
	 */
	public static void info(final Logger logger, final Object logFormat, final Throwable e) {
		if (logger != null && logger.isInfoEnabled()) {
			logger.info(LogFormat(logger, logFormat), e);
		}
	}

	/**
	 * warn级别日志
	 * 
	 * @author XieXP
	 * @date 2016年3月1日 下午4:50:56
	 * @param logger
	 *            日志对象
	 * @param logFormat
	 *            日志参数
	 */
	public static void warn(final Logger logger, final Object logFormat) {
		if (logger != null) {
			logger.warn(LogFormat(logger, logFormat));
		}
	}

	/**
	 * warn级别日志
	 * 
	 * @author XieXP
	 * @date 2016年3月1日 下午4:51:00
	 * @param logger
	 *            日志对象
	 * @param logFormat
	 *            日志参数
	 * @param e
	 *            异常
	 */
	public static void warn(final Logger logger, final Object logFormat, final Throwable e) {
		if (logger != null) {
			logger.warn(LogFormat(logger, logFormat), e);
		}
	}

	/**
	 * error级别日志
	 * 
	 * @author XieXP
	 * @date 2016年3月1日 下午4:51:05
	 * @param logger
	 *            日志对象
	 * @param logFormat
	 *            日志参数
	 */
	public static void error(final Logger logger, final Object logFormat) {
		if (logger != null) {
			logger.error(LogFormat(logger, logFormat));
		}
	}

	/**
	 * error级别日志
	 * 
	 * @author XieXP
	 * @date 2016年3月1日 下午4:51:10
	 * @param logger
	 *            日志对象
	 * @param logFormat
	 *            日志参数
	 * @param e
	 *            异常
	 */
	public static void error(final Logger logger, final Object logFormat, final Throwable e) {
		if (logger != null) {
			logger.error(LogFormat(logger, logFormat), e);
		}
	}

	/**
	 * fatal级别日志
	 * 
	 * @author XieXP
	 * @date 2016年3月1日 下午4:51:15
	 * @param logger
	 *            日志对象
	 * @param logFormat
	 *            日志参数
	 */
	public static void fatal(final Logger logger, final Object logFormat) {
		if (logger != null) {
			logger.fatal(LogFormat(logger, logFormat));
		}
	}

	/**
	 * fatal级别日志
	 * 
	 * @author XieXP
	 * @date 2016年3月1日 下午4:51:21
	 * @param logger
	 *            日志对象
	 * @param logFormat
	 *            日志参数
	 * @param e
	 *            异常
	 */
	public static void fatal(final Logger logger, final Object logFormat, final Throwable e) {
		if (logger != null) {
			logger.fatal(LogFormat(logger, logFormat), e);
		}
	}

	private static String LogFormat(final Logger logger, final Object logFormat) {
		if (logFormat == null) {
			return null;
		}
		Map<String, String> logParamMap = null;
		try {
			logParamMap = gson.fromJson(gson.toJson(logFormat), new TypeToken<Map<String, String>>() {
			}.getType());
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
		if (logParamMap == null || logParamMap.size() <= 0) {
			return null;
		}
		StringBuffer formatBuffer = new StringBuffer();
		for (Map.Entry<String, String> logParam : logParamMap.entrySet()) {
			try {
				formatBuffer.append("    ").append(logParam.getKey()).append(logParam.getValue());
			} catch (Exception e) {
				logger.error(e);
			}
		}
		return formatBuffer.toString();
	}

}
