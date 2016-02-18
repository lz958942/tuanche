/**
 * Copyright (c) 2016, Stupid Bird and/or its affiliates. All rights reserved.
 * STUPID BIRD PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 * @Project : square-encryption
 * @Title : EncryptUtilTest.java
 * @Package : com.tuanche.security
 * @author <a href="http://www.lizhaoweb.net">李召(Jhon.Lee)</a>
 * @Date : 2016年2月18日
 * @Time : 下午4:50:29
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
package com.tuanche.security;

import java.io.IOException;

import org.junit.Test;

/**
 * 
 * @author <a href="http://www.lizhaoweb.cn">李召(Jhon.Lee)</a>
 * @version
 * @notes Created on 2016年2月18日<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p />
 * 
 */
public class EncryptUtilTest {

	@Test
	public void encryptAndDecrypt() {
		String encryptString = EncryptUtil.encrypt("123456");
		System.out.println(encryptString);
		try {
			System.out.println(EncryptUtil.decrypt(encryptString));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void a() {
		// byte[] sourceBuf = "123456".getBytes(Charset.UTF8);
		// String encryptString = EncryptUtil.TripleDES_CBC_Encrypt(sourceBuf,
		// deskey, ivParam);
	}

	@Test
	public void encrypt() {
		String user = "oneadmin";
		System.out.println("原始字符串 " + user);
		System.out.println("MD5加密 " + EncryptUtil.encodeMD5(user));
		System.out.println("SHA加密 " + EncryptUtil.encodeSHA(user));
		String base64Str = EncryptUtil.encodeBase64(user);
		System.out.println("Base64加密 " + base64Str);
		try {
			System.out.println("Base64解密 " + EncryptUtil.decodeBase64(base64Str));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
