package com.tuanche.common.chinesetpinyin;

import org.junit.Test;

/**
 * 拼音测试
 *
 */
public class PinyinTest {
	@Test
	public void test() {
		Pinyin hanyu = new Pinyin();
		// 中英文混合的一段文字
		String str = "重庆";
		String strPinyin = hanyu.getStringPinYin(str);
		System.out.println(strPinyin);
	}
}
