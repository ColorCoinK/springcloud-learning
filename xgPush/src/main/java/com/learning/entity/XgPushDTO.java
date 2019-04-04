package com.learning.entity;

import java.io.Serializable;

/**
 * @description:信鸽推送需要传递的参数
 * @createBy luohui 2018/08/26
 */
public class XgPushDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;

	private String body;

	private String device_token;

	public XgPushDTO() {
	}

	public XgPushDTO(String title, String body) {
		this.title = title;
		this.body = body;
	}

	public XgPushDTO(String title, String body, String device_token) {
		this.title = title;
		this.body = body;
		this.device_token = device_token;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDevice_token() {
		return device_token;
	}

	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}

	@Override
	public String toString() {
		return "XgPushDTO [title=" + title + ", body=" + body + "]";
	}

}
