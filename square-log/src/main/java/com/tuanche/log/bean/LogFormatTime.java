package com.tuanche.log.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

import com.google.gson.annotations.SerializedName;

public class LogFormatTime implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3322457212808920335L;

	/** 时间 */
	@Setter
	@Getter
	@SerializedName("[dateTime]")
	private String dateTime;

	/** 模块 */
	@Setter
	@Getter
	@SerializedName("[model]")
	private String model;

	/** 调用对象 */
	@Setter
	@Getter
	@SerializedName("[clazz]")
	private String clazz;

	/** 方法 */
	@Setter
	@Getter
	@SerializedName("[method]")
	private String method;

	/** 方法参数 */
	@Setter
	@Getter
	@SerializedName("[params]")
	private String paramsJson;

	/** 请求开始时间戳 */
	@Setter
	@Getter
	@SerializedName("[start_time]")
	private Long startTime;

	/** 请求结束时间戳 */
	@Setter
	@Getter
	@SerializedName("[end_time]")
	private Long endTime;

	/** 总用时 */
	@SerializedName("[total_time]")
	private Long useTime;

	public Long getUseTime() {
		if (this.startTime != null && this.endTime != null) {
			this.useTime = this.endTime - this.startTime;
		}
		return this.useTime;
	}

	public LogFormatTime() {
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
	 * @param startTime
	 *            请求开始时间戳
	 * @param endTime
	 *            请求结束时间戳
	 */
	public LogFormatTime(String dateTime, String model, String clazz, String method, String paramsJson, Long startTime, Long endTime) {
		super();
		this.dateTime = dateTime;
		this.model = model;
		this.clazz = clazz;
		this.method = method;
		this.paramsJson = paramsJson;
		this.startTime = startTime;
		this.endTime = endTime;
		if (this.startTime != null && this.endTime != null) {
			this.useTime = this.endTime - this.startTime;
		}
	}

}
