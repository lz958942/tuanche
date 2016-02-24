/**
 * Copyright (c) 2016, Stupid Bird and/or its affiliates. All rights reserved.
 * STUPID BIRD PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 * @Project : square-log
 * @Title : PrintRunTimeAspect.java
 * @Package : com.tuanche.log.aspect
 * @author <a href="http://www.lizhaoweb.net">李召(Jhon.Lee)</a>
 * @Date : 2016年2月19日
 * @Time : 上午10:33:18
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package com.tuanche.log.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.tuanche.log.annotation.PrintMethodRunTime;

/**
 * 
 * @author <a href="http://www.lizhaoweb.cn">李召(Jhon.Lee)</a>
 * @version
 * @notes Created on 2016年2月19日<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p />
 * 
 */
// 该注解标示该类为切面类
@Aspect
// 注入依赖
@Component
public class PrintMethodRunTimeAspect extends AbstractBaseAspect {

	// protected Logger logger = Logger.getRootLogger();

	// 切点
	@Pointcut("@annotation(com.tuanche.log.annotation.PrintMethodRunTime)")
	public void printMethodRunTimePointcut() {
	}

	@Around("printMethodRunTimePointcut()")
	public Object processText(ProceedingJoinPoint proceedingJoinPoint) {
		Object result = null;
		PrintMethodRunTime methodRunTime = this.findMethodAnnotation(proceedingJoinPoint, PrintMethodRunTime.class);

		String messageFormat = null;
		if (methodRunTime != null) {
			messageFormat = methodRunTime.messageFormat();
		}
		if (messageFormat == null) {
			messageFormat = "";
		}

		String message = messageFormat;

		String targetClassName = null;
		while (message.indexOf("{className}") > -1) {
			targetClassName = this.getClassName(proceedingJoinPoint);
			message = message.replace("{className}", targetClassName);
		}

		String methodName = null;
		while (message.indexOf("{methodName}") > -1) {
			methodName = this.getMethodName(proceedingJoinPoint);
			message = message.replace("{methodName}", methodName);
		}

		long startMillisecond = System.currentTimeMillis();
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long endMillisecond = System.currentTimeMillis();
		long runTime = endMillisecond - startMillisecond;

		while (message.indexOf("{millisecond}") > -1) {
			message = message.replace("{millisecond}", runTime + "");
		}

		if (logger.isInfoEnabled()) {
			logger.info(message);
		}

		return result;
	}
}
