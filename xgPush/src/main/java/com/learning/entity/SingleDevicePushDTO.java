package com.learning.entity;

import com.tencent.xinge.Message;

public class SingleDevicePushDTO {

	// 推送目标
	private String audience_type;

	// 推送平台
	private String plaform;

	// 消息类型
	private String message_type;

	// 消息体
	private Message message;

	public String getAudience_type() {
		return audience_type;
	}

	public void setAudience_type(String audience_type) {
		this.audience_type = audience_type;
	}

	public String getPlaform() {
		return plaform;
	}

	public void setPlaform(String plaform) {
		this.plaform = plaform;
	}

	public String getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SingleDevicePushDTO [audience_type=" + audience_type + ", plaform=" + plaform
				       + ", message_type="
				       + message_type + ", message=" + message + "]";
	}

}
