/**
 * Copyright (c) 2016, Stupid Bird and/or its affiliates. All rights reserved.
 * STUPID BIRD PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 * @Project : square-log
 * @Title : RunTimeLog.java
 * @Package : com.tuanche.log.annotation
 * @author <a href="http://www.lizhaoweb.net">李召(Jhon.Lee)</a>
 * @Date : 2016年2月18日
 * @Time : 下午6:55:43
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
package com.tuanche.log.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h1>注解 - 打印方法运行时间</h1>
 * 
 * @author <a href="http://www.lizhaoweb.cn">李召(Jhon.Lee)</a>
 * @version 1.0.0.0.1
 * @notes Created on 2016年2月18日<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p />
 * 
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface PrintMethodRunTime {

	/**
	 * 打印信息的格式。<br/>
	 * 
	 * 默认值为：
	 * "Run Method [{className}.{methodName}] need {millisecond} millisecond。"<br/>
	 * {className} 获取运行类名。<br/>
	 * {methodName} 获取运行方法名。<br/>
	 * {millisecond} 获取执行毫秒数。<br/>
	 * 
	 * @return 返回打印信息格式。
	 */
	String messageFormat() default "Run Method [{className}.{methodName}] need {millisecond} millisecond。";
	// String messageFormat() default
	// "Run Method [{className}.{methodName}] need {dd}days {HH}houres {mm}minute {ss}second {SSS}millisecond({millisecond}millisecond)。";
}
