/**
 * Copyright (c) 2016, Stupid Bird and/or its affiliates. All rights reserved.
 * STUPID BIRD PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 * @Project : square-log
 * @Title : UserFactory.java
 * @Package : com.tuanche.log.aspect
 * @author <a href="http://www.lizhaoweb.net">李召(Jhon.Lee)</a>
 * @Date : 2016年2月19日
 * @Time : 下午2:55:56
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;

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
public class UserFactory {

	private Map<String, User> userMap = new HashMap<String, User>();

	@PrintMethodRunTime(messageFormat = "运行方法 [{className}.{methodName}] 耗时 {millisecond} 毫秒。")
	public void initUsers() {
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			String id = UUID.randomUUID().toString();
			User user = new User(id, "User" + i, random.nextInt(100), new Date());
			// System.out.println(user);
			userMap.put(id, user);
		}
		// System.out.println(userMap);
	}

	@PrintMethodRunTime
	public User getUser() {
		Set<Entry<String, User>> entrySet = userMap.entrySet();
		User user = null;
		for (Entry<String, User> entry : entrySet) {
			String key = entry.getKey();
			user = userMap.get(key);
			// System.out.println(user);
		}
		return user;
	}
}
