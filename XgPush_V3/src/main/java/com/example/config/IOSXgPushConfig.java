package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value = "xgpush.ios")
public class IOSXgPushConfig {

	private String access_id;

	private String access_key;

	// 1:开发环境;2:生产环境
	private int ios_environment;

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

	public int getIos_environment() {
		return ios_environment;
	}

	public void setIos_environment(int ios_environment) {
		this.ios_environment = ios_environment;
	}

	@Override
	public String toString() {
		return "IOSXgPushConfig [access_id=" + access_id + ", access_key=" + access_key
				       + ", ios_environment="
				       + ios_environment + "]";
	}

}
