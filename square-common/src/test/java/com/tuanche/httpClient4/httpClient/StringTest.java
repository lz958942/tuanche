package com.tuanche.httpClient4.httpClient;

import org.junit.Assert;
import org.junit.Test;

import com.tuanche.commons.util.StringUtils;

/**
 * Unit test for simple App.
 */
public class StringTest {
	@Test
	public void isNotEmpty() {
		System.out.println("mothod=isNotEmpty");
		boolean flage = StringUtils.isNotEmpty("");
		Assert.assertFalse(flage);
		System.out.println("flage=" + flage);
		boolean flage1 = StringUtils.isNotEmpty("abc");
		Assert.assertTrue(flage1);
		System.out.println("flage1=" + flage1);
		boolean flage2 = StringUtils.isNotEmpty("0");
		Assert.assertTrue(flage2);
		System.out.println("flage2=" + flage2);
		boolean flage3 = StringUtils.isNotEmpty(null);
		Assert.assertFalse(flage3);
		System.out.println("flage3=" + flage3);
	}

	@Test
	public void isNotEmptyOrZero() {
		System.out.println("mothod=isNotEmptyOrZero");
		boolean flage = StringUtils.isNotEmptyOrZero("");
		Assert.assertFalse(flage);
		System.out.println("flage=" + flage);
		boolean flage1 = StringUtils.isNotEmptyOrZero("abc");
		Assert.assertTrue(flage1);
		System.out.println("flage1=" + flage1);
		boolean flage2 = StringUtils.isNotEmptyOrZero("0");
		Assert.assertFalse(flage2);
		System.out.println("flage2=" + flage2);
		boolean flage3 = StringUtils.isNotEmptyOrZero(null);
		Assert.assertFalse(flage3);
		System.out.println("flage3=" + flage3);
	}

	@Test
	public void strToInt() {
		System.out.println("mothod=strToInt");
		int inta = StringUtils.strToInt("");
		Assert.assertEquals(0, inta);
		System.out.println("inta=" + inta);

		int intb = StringUtils.strToInt("123");
		Assert.assertEquals(123, intb);
		System.out.println("intb=" + intb);

		// int intc=StringUtils.strToInt("abc");
		// Assert.assertEquals(0, intc);
		// System.out.println("intc="+intc);
	}

	@Test
	public void strToLong() {
		System.out.println("mothod=strToLong");
		long inta = StringUtils.strToLong("");
		Assert.assertEquals(0, inta);
		System.out.println("inta=" + inta);

		long intb = StringUtils.strToLong("123");
		Assert.assertEquals(123, intb);
		System.out.println("intb=" + intb);

		long intc = StringUtils.strToLong(null);
		Assert.assertEquals(0, intc);
		System.out.println("intc=" + intc);
	}

	@Test
	public void strToDouble() {
		System.out.println("mothod=strToDouble");
		double inta = StringUtils.strToDouble("");
		System.out.println("inta=" + inta);

		double intb = StringUtils.strToDouble("123");
		System.out.println("intb=" + intb);

		double intc = StringUtils.strToDouble(null);
		System.out.println("intc=" + intc);
	}

	@Test
	public void strToByte() {
		try {
			System.out.println("mothod=strToByte");
			byte[] stra = StringUtils.strToByte("");
			System.out.println("inta=" + stra);

			byte[] strb = StringUtils.strToByte("123");
			System.out.println("intb=" + strb);

			byte[] strc = StringUtils.strToByte(null);
			System.out.println("intc=" + strc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void encodeUTF8() {
		try {
			System.out.println("mothod=encodeUTF8");
			String str = StringUtils.encodeUTF8("");
			System.out.println("str=" + str);

			String str1 = StringUtils.encodeUTF8(null);
			System.out.println("str1=" + str1);

			String str2 = StringUtils.encodeUTF8("abc");
			System.out.println("str2=" + str2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void decodeUTF8() {
		try {
			System.out.println("mothod=decodeUTF8");
			String str = StringUtils.decodeUTF8("");
			System.out.println("str=" + str);

			String str1 = StringUtils.decodeUTF8(null);
			System.out.println("str1=" + str1);

			String str2 = StringUtils.decodeUTF8("abc");
			System.out.println("str2=" + str2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void leftSubString() {
		try {
			System.out.println("mothod=leftSubString");
			String str = StringUtils.leftSubString("",2);
			System.out.println("str=" + str);

			String str1 = StringUtils.leftSubString(null,2);
			System.out.println("str1=" + str1);

			String str2 = StringUtils.leftSubString("abc",2);
			System.out.println("str2=" + str2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void rightSubString() {
		try {
			System.out.println("mothod=rightSubString");
			String str = StringUtils.rightSubString("",2);
			System.out.println("str=" + str);

			String str1 = StringUtils.rightSubString(null,2);
			System.out.println("str1=" + str1);

			String str2 = StringUtils.rightSubString("abc",2);
			System.out.println("str2=" + str2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
