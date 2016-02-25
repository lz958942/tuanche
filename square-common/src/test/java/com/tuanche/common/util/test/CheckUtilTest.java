package com.tuanche.common.util.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.tuanche.common.constant.Constant;
import com.tuanche.commons.util.CheckUtil;

/**
 * 参数校验单元测试类
 * @author 梁晓东
 *
 */
public class CheckUtilTest {
	/**
	 * 参数校验类单元测试
	 */
	 @Test
	 public void test(){
		 //手机号校验
		 System.out.println("正确手机号校验结果:"+CheckUtil.isValidateMobile("13001125828"));
		 System.out.println("错误手机号校验结果:"+CheckUtil.isValidateMobile("23001125828"));
		 
		 //电子邮箱校验
		 System.out.println("正确电子邮件校验结果:"+CheckUtil.isValidateEmail("13001125828@163.com"));
		 System.out.println("错误电子邮件校验结果:"+CheckUtil.isValidateEmail("13001125828@"));
		 
		 //IP校验
		 System.out.println("正确IP校验结果:"+CheckUtil.isValidateIp("192.168.1.55"));
		 System.out.println("错误IP校验结果:"+CheckUtil.isValidateIp("1.2."));
		 
		 //检查JAVA对象是否为空
		 Object o = null;
		 System.out.println("对象为空:"+CheckUtil.checkObjectIsNull(o));
		 o = new Object();
		 System.out.println("对象不为空:"+CheckUtil.checkObjectIsNull(o));
		 
		 //检测Java对象是否为空. 同时检测多个指定的对象, 如果存在一个为空, 则全部为空.
		 System.out.println("【对象数量可变】检测多个对象,全不为空:"+CheckUtil.checkVariableObjectArrayIsNull("abc","bcd"));
		 System.out.println("【对象数量可变】检测多个对象,部分为空:"+CheckUtil.checkVariableObjectArrayIsNull("abc","bcd",null));
		 
		 //检测Java对象是否为空. 同时检测多个指定的对象, 如果存在一个为空, 则全部为空.
		 Object[] objs = {"abc","bcd"};
		 System.out.println("【对象数量不变】检测多个对象,全不为空:"+CheckUtil.checkObjectArrayIsNull(objs));
		 objs[1]=null;
		 System.out.println("【对象数量不变】检测多个对象,部分为空:"+CheckUtil.checkObjectArrayIsNull(objs));
		 
		 //检查String字符串是否为空
		 System.out.println("String字符串不为空:"+CheckUtil.checkStringIsNull("abc"));
		 System.out.println("String字符串为空:"+CheckUtil.checkStringIsNull(null));
		 
		 //严格的检测字符串是否为空:1.内存为分配 ; 2.长度为0; 3.参数本身为'null'的字符串
		 System.out.println("null字符串也认为是空:"+CheckUtil.checkStringIsNullStrictly("null"));
		 System.out.println("null本身为空:"+CheckUtil.checkStringIsNullStrictly(null));
		 
		 //判断集合是否为空
		 Set<String> set = new HashSet<String>();
		 System.out.println("集合为空:"+CheckUtil.checkCollectionIsNullOrEmpty(set));
		 set.add("abc");
		 System.out.println("集合为空:"+CheckUtil.checkCollectionIsNullOrEmpty(set));
		 
		 //判断集合是否为空
		 Map<String,String> map = new HashMap<String,String>();
		 System.out.println("map为空:"+CheckUtil.checkMapIsNullOrEmpty(map));
		 map.put("key1", "abc");
		 System.out.println("map为空:"+CheckUtil.checkMapIsNullOrEmpty(map));
		 
		 //对参数用UTF-8编码
		 System.out.println("UTF-8编码:"+CheckUtil.encodeUrlWithUTF8("中国"));
		 
		 //对参数用指定格式编码
		 System.out.println("指定格式编码(指定GBK):"+CheckUtil.encodeUrl("中国",Constant.Charset.GBK));
	 }
}
