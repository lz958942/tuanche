package com.tuanche.log.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

import com.google.gson.annotations.SerializedName;

@Setter
@Getter
public class LogFormat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5400203780622880200L;

	/** 时间 */
	@SerializedName("[dateTime]")
	private String dateTime;

	/** 模块 */
	@SerializedName("[model]")
	private String model;

	/** 调用对象 */
	@SerializedName("[clazz]")
	private String clazz;

	/** 方法 */
	@SerializedName("[method]")
	private String method;

	/** 方法参数 */
	@SerializedName("[params]")
	private String paramsJson;

	public LogFormat() {
		super();
	}

	/**
	 * @param dateTime
	 *            时间
	 * @param model
	 *            模块
	 * @param clazz
	 *            调用对象
	 * @param method
	 *            方法
	 * @param paramsJson
	 *            方法参数
	 */
	public LogFormat(String dateTime, String model, String clazz, String method, String paramsJson) {
		super();
		this.dateTime = dateTime;
		this.model = model;
		this.clazz = clazz;
		this.method = method;
		this.paramsJson = paramsJson;
	}

}
