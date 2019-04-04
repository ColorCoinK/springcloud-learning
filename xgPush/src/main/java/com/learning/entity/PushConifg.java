package com.learning.entity;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: PushConifg
 * @Description: 信鸽推送    通用基础参数
 * @Created by dew on 2018/08/25
 */
@Component
@ConfigurationProperties(prefix = "push")
public class PushConifg implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long android_access_id;

	private String android_secret_key;

	private Long ios_access_id;

	private String ios_secret_key;

	private Long timestamp;

	private int ios_environment;

	public Long getAndroid_access_id() {
		return android_access_id;
	}

	public void setAndroid_access_id(Long android_access_id) {
		this.android_access_id = android_access_id;
	}

	public String getAndroid_secret_key() {
		return android_secret_key;
	}

	public void setAndroid_secret_key(String android_secret_key) {
		this.android_secret_key = android_secret_key;
	}

	public Long getIos_access_id() {
		return ios_access_id;
	}

	public void setIos_access_id(Long ios_access_id) {
		this.ios_access_id = ios_access_id;
	}

	public String getIos_secret_key() {
		return ios_secret_key;
	}

	public void setIos_secret_key(String ios_secret_key) {
		this.ios_secret_key = ios_secret_key;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public int getIos_environment() {
		return ios_environment;
	}

	public void setIos_environment(int ios_environment) {
		this.ios_environment = ios_environment;
	}

}
