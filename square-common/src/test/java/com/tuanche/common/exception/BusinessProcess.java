package com.tuanche.common.exception;

import com.tuanche.common.constant.CommonCode;
import com.tuanche.common.excepiton.BusinessException;

/**
 * 业务处理方法测试
 * 
 * @author 梁晓东
 *
 */
public class BusinessProcess {
	/**
	 * 业务处理
	 */
	public static void processBusiness() throws BusinessException {
		try {
			int result = 5 / 0;
		} catch (Exception e) {
			throw new BusinessException(CommonCode.BUSINESSEXCEPITON.getMsg(), e, CommonCode.BUSINESSEXCEPITON.getCode());
		}
	}
}
