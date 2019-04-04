package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "xgpush.android")
public class AndroidXgPushConfig {

	private String access_id;

	private String access_key;

	public String getAccess_id() {
		return access_id;
	}

	public void setAccess_id(String access_id) {
		this.access_id = access_id;
	}

	public String getAccess_key() {
		return access_key;
	}

	public void setAccess_key(String access_key) {
		this.access_key = access_key;
	}

	@Override
	public String toString() {
		return "AndroidXgPushConfig [access_id=" + access_id + ", access_key=" + access_key + "]";
	}

}
