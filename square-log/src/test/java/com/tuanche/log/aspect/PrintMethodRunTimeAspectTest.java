/**
 * Copyright (c) 2016, Stupid Bird and/or its affiliates. All rights reserved.
 * STUPID BIRD PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 * @Project : square-log
 * @Title : PrintMethodRunTimeAspectTest.java
 * @Package : com.tuanche.log.aspect
 * @author <a href="http://www.lizhaoweb.net">李召(Jhon.Lee)</a>
 * @Date : 2016年2月19日
 * @Time : 下午2:13:01
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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@RunWith(SpringJUnit4ClassRunner.class)
// @WebAppConfiguration
@ContextConfiguration({ "classpath*:/schema/spring/*.xml" })
public class PrintMethodRunTimeAspectTest {

	@Autowired
	private UserFactory factory;

	@Test
	public void test() {
		factory.initUsers();

		User user = factory.getUser();
		System.out.println(user);
	}
}
