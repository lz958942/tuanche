package com.tuanche.common.chinesetpinyin;

import org.junit.Test;

/**
 * 
 * 拼音单元测试
 *
 */
public class Pinyin4jUtilTest {
	@Test
	public void test() {
		String str = "重庆";
		System.out.println(Pinyin4jUtil.makeStringByStringSet(Pinyin4jUtil.str2Pinyin(str)));
		System.out.println(Pinyin4jUtil.makeStringByStringSet(Pinyin4jUtil.str2Pinyin(str, Pinyin4jUtil.RET_PINYIN_TYPE_HEADCHAR)));
		System.out.println(Pinyin4jUtil.getStringPinYin("重庆"));
	}
}
