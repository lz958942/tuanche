/**
 * Copyright (c) 2015, Stupid Bird and/or its affiliates. All rights reserved.
 * STUPID BIRD PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 * @Project : LiZhao Misc Spring Plugin Aop
 * @Title : BaseAspect.java
 * @Package : net.lizhaoweb.spring.aop.aspect
 * @author <a href="http://www.lizhaoweb.net">李召(Jhon.Lee)</a>
 * @Date : 2015年12月24日
 * @Time : 上午11:08:05
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

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author <a href="http://www.lizhaoweb.cn">李召(Jhon.Lee)</a>
 * @version
 * @notes Created on 2015年12月24日<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p />
 * 
 */
public abstract class AbstractBaseAspect {

	// 本地异常日志记录对象
	protected final Logger logger = Logger.getLogger(this.getClass());

	protected Gson gson = null;

	/**
	 * 
	 */
	public AbstractBaseAspect() {
		super();
		gson = new GsonBuilder().setDateFormat("yyy-MM-dd HH:mm:ss.SSS").create();
	}

	// 获取调用对象类型。
	protected Class<?> getClass(JoinPoint joinPoint) {
		Object target = joinPoint.getTarget();
		Class<?> targetClass = target.getClass();
		return targetClass;
	}

	// 获取调用方法声明。
	protected String getMethodStatement(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String methodStatement = signature.toLongString();
		return methodStatement;
	}

	// 获取调用方法声明。
	protected String getMethodName(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String methodStatement = signature.toShortString();
		return methodStatement;
	}

	// 获取调用对象的所有方法。
	protected Method[] getMethods(JoinPoint joinPoint) {
		Class<?> targetClass = this.getClass(joinPoint);
		Method[] methods = targetClass.getMethods();
		return methods;
	}

	protected String getClassName(JoinPoint joinPoint) {
		Class<?> targetClass = this.getClass(joinPoint);
		String targetClassName = targetClass.getName();
		return targetClassName;
	}

	// 在调用方法的注解中查找指定注解。
	protected <T extends Annotation> T findMethodAnnotation(JoinPoint joinPoint, Class<T> clazz) {
		String methodStatement = this.getMethodStatement(joinPoint);

		Method[] methods = this.getMethods(joinPoint);

		T annotation = null;
		for (Method method : methods) {
			String methodStatementTemp = method.toString();
			if (methodStatementTemp.equals(methodStatement)) {
				annotation = method.getAnnotation(clazz);
				break;
			}
		}
		return annotation;
	}

	// 在调用对象的注解中查找指定注解。
	protected <T extends Annotation> T findClassAnnotation(JoinPoint joinPoint, Class<T> clazz) {
		Class<?> targetClass = this.getClass(joinPoint);
		T annotation = targetClass.getAnnotation(clazz);
		return annotation;
	}
}
