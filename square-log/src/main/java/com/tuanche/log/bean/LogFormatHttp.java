package com.tuanche.log.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

import com.google.gson.annotations.SerializedName;

public class LogFormatHttp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5731095366596492664L;

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

	/** 请求地址 */
	@Setter
	@Getter
	@SerializedName("[url]")
	private String url;

	/** 响应代码 */
	@Setter
	@Getter
	@SerializedName("[http_code]")
	private Integer code;

	/** 请求端IP */
	@Setter
	@Getter
	@SerializedName("[client_ip]")
	private String clientIp;

	/** 服务器IP */
	@Setter
	@Getter
	@SerializedName("[server_ip]")
	private String serverIp;

	public Long getUseTime() {
		if (this.startTime != null && this.endTime != null) {
			this.useTime = this.endTime - this.startTime;
		}
		return this.useTime;
	}

	public LogFormatHttp() {
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
	 * @param url
	 *            请求地址
	 * @param code
	 *            响应代码
	 * @param clientIp
	 *            请求端IP
	 * @param serverIp
	 *            服务器IP
	 */
	public LogFormatHttp(String dateTime, String model, String clazz, String method, String paramsJson, Long startTime, Long endTime, String url, Integer code, String clientIp, String serverIp) {
		super();
		this.dateTime = dateTime;
		this.model = model;
		this.clazz = clazz;
		this.method = method;
		this.paramsJson = paramsJson;
		this.startTime = startTime;
		this.endTime = endTime;
		this.url = url;
		this.code = code;
		this.clientIp = clientIp;
		this.serverIp = serverIp;
		if (this.startTime != null && this.endTime != null) {
			this.useTime = this.endTime - this.startTime;
		}
	}

}
