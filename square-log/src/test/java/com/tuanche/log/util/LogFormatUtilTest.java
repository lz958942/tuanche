package com.tuanche.log.util;

import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tuanche.log.bean.LogFormatTime;

public class LogFormatUtilTest {

	private static Gson gson = new GsonBuilder().serializeNulls().create();

	public static void debug(final Logger logger, final Object logFormat) {
		if (logger != null && logger.isDebugEnabled()) {
			logger.debug(LogFormat(logger, logFormat));
		}
	}

	public static void debug(final Logger logger, final Object logFormat, final Throwable e) {
		if (logger != null && logger.isDebugEnabled()) {
			logger.debug(LogFormat(logger, logFormat), e);
		}
	}

	public static void info(final Logger logger, final Object logFormat) {
		if (logger != null && logger.isInfoEnabled()) {
			logger.info(LogFormat(logger, logFormat));
		}
	}

	public static void info(final Logger logger, final Object logFormat, final Throwable e) {
		if (logger != null && logger.isInfoEnabled()) {
			logger.info(LogFormat(logger, logFormat), e);
		}
	}

	public static void warn(final Logger logger, final Object logFormat) {
		if (logger != null) {
			logger.warn(LogFormat(logger, logFormat));
		}
	}

	public static void warn(final Logger logger, final Object logFormat, final Throwable e) {
		if (logger != null) {
			logger.warn(LogFormat(logger, logFormat), e);
		}
	}

	public static void error(final Logger logger, final Object logFormat) {
		if (logger != null) {
			logger.error(LogFormat(logger, logFormat));
		}
	}

	public static void error(final Logger logger, final Object logFormat, final Throwable e) {
		if (logger != null) {
			logger.error(LogFormat(logger, logFormat), e);
		}
	}
	
	public static void fatal(final Logger logger, final Object logFormat) {
		if (logger != null) {
			logger.fatal(LogFormat(logger, logFormat));
		}
	}

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


	@Test
	public void printLog() {
		//LogFormat logFormat = new LogFormat("1","1",LogFormatUtil.class.getName(), "1", "1");
		LogFormatTime logFormat = new LogFormatTime("1","1",LogFormatUtil.class.getName(), "1", "1", 1000L, 1100L);
		//LogFormatHttp logFormat = new LogFormatHttp("1", "1", LogFormatUtil.class.getName(), "1", "1", 1000L, 1100L, "1", 10, "1", "1");
		Logger logger = Logger.getLogger(LogFormatUtil.class);
		debug(logger, logFormat);
		debug(logger, logFormat, null);
		info(logger, logFormat);
		info(logger, logFormat, null);
		warn(logger, logFormat);
		warn(null, logFormat, null);
		error(logger, logFormat);
		error(logger, null, null);
		try {
			int i = 1/0;
		} catch (Exception e) {
			fatal(logger, "", e);
		}
		fatal(logger, logFormat);
	}

}
