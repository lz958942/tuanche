package com.tuanche.common.exception;

import org.junit.Test;

import com.tuanche.common.excepiton.BusinessException;

/**
 * 自定义异常测试类
 * 
 * @author 梁晓东
 *
 */
public class ExceptionTest {
	/**
	 * 自定义异常类测试
	 */
	@Test
	public void test() {
		try {
			BusinessProcess.processBusiness();
		} catch (BusinessException e) {
			e.printStackTrace();
			System.out.println("错误码："+e.geterrCode());
			System.out.println("错误类型："+e.geterrMsg());
		}
	}

}
