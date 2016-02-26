package com.tuanche.common.constant;

public enum CommonCode {

	SUCCESS("10000", ""),
    BUSINESSEXCEPITON("100001", "业务异常"),
	USER_EXCEPTION("100002", "用户未登陆"),
	HEAD_EXCEPTION("10003", "头信息异常"),
	PARAMS_EXCEPITON("100004", "业务异常"),
	DB_EXCEPTION("20001", "数据库异常");

	private String code;

	private String msg;

	private CommonCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
