/**
 * Copyright (c) 2016, Stupid Bird and/or its affiliates. All rights reserved.
 * STUPID BIRD PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 * @Project : square-encryption
 * @Title : Constant.java
 * @Package : com.tuanche.security.util
 * @author <a href="http://www.lizhaoweb.net">李召(Jhon.Lee)</a>
 * @Date : 2016年2月18日
 * @Time : 下午3:45:29
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
package com.tuanche.security.util;

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
public class Constant {

	/**
	 * 字符集
	 * 
	 * @author <a href="http://www.lizhaoweb.cn">李召(Jhon.Lee)</a>
	 * @version Constant
	 * @notes Created on 2016年2月18日<br>
	 *        Revision of last commit:$Revision$<br>
	 *        Author of last commit:$Author$<br>
	 *        Date of last commit:$Date$<br>
	 *        <p />
	 * 
	 */
	public static final class Charset {
		/** 字符集 ISO-8859 */
		public static final String ISO_8859 = "ISO-8859";
		/** 字符集 ISO-8859-1 */
		public static final String ISO_8859_1 = "ISO-8859-1";
		/** 字符集 ISO8859-2 */
		public static final String ISO_8859_2 = "ISO-8859-2";
		/** 字符集 GBK */
		public static final String GBK = "GBK";
		/** 字符集 BIG5 */
		public static final String BIG5 = "BIG5";
		/** 字符集 GB2312 */
		public static final String GB2312 = "GB2312";
		/** 字符集 GB18030 */
		public static final String GB18030 = "GB18030";
		/** 字符集 UTF-8 */
		public static final String UTF8 = "UTF-8";
	}

	/**
	 * 算法
	 * 
	 * @author <a href="http://www.lizhaoweb.cn">李召(Jhon.Lee)</a>
	 * @version Constant
	 * @notes Created on 2016年2月18日<br>
	 *        Revision of last commit:$Revision$<br>
	 *        Author of last commit:$Author$<br>
	 *        Date of last commit:$Date$<br>
	 *        <p />
	 * 
	 */
	public static final class Algorithm {

		/**
		 * 摘要
		 * 
		 * @author <a href="http://www.lizhaoweb.cn">李召(Jhon.Lee)</a>
		 * @version Constant.Algorithm
		 * @notes Created on 2016年2月18日<br>
		 *        Revision of last commit:$Revision$<br>
		 *        Author of last commit:$Author$<br>
		 *        Date of last commit:$Date$<br>
		 *        <p />
		 * 
		 */
		public static final class Summary {
			public static final String MD2 = "MD2";
			public static final String MD5 = "MD5";
			public static final String SHA = "SHA";
			public static final String SHA_1 = "SHA-1";
			public static final String SHA_256 = "SHA-256";
			public static final String SHA_384 = "SHA-384";
			public static final String SHA_512 = "SHA-512";
		}

		/**
		 * 对称
		 * 
		 * @author <a href="http://www.lizhaoweb.cn">李召(Jhon.Lee)</a>
		 * @version Constant.Algorithm
		 * @notes Created on 2016年2月18日<br>
		 *        Revision of last commit:$Revision$<br>
		 *        Author of last commit:$Author$<br>
		 *        Date of last commit:$Date$<br>
		 *        <p />
		 * 
		 */
		public static final class Symmetry {
			public static final String DES = "DES";
		}
	}
}
