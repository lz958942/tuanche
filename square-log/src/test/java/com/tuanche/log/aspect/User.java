/**
 * Copyright (c) 2016, Stupid Bird and/or its affiliates. All rights reserved.
 * STUPID BIRD PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 * @Project : square-log
 * @Title : User.java
 * @Package : com.tuanche.log.aspect
 * @author <a href="http://www.lizhaoweb.net">李召(Jhon.Lee)</a>
 * @Date : 2016年2月19日
 * @Time : 下午2:54:37
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String id;

	private String name;

	private int age;

	private Date brithday;
}
