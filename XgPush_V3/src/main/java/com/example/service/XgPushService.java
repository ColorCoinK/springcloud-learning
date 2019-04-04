package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.config.AndroidXgPushConfig;
import com.example.config.IOSXgPushConfig;
import com.example.util.CustomJsonUtil;
import com.tencent.xinge.XingeApp;
import com.tencent.xinge.bean.Alert;
import com.tencent.xinge.bean.Aps;
import com.tencent.xinge.bean.AudienceType;
import com.tencent.xinge.bean.Message;
import com.tencent.xinge.bean.MessageAndroid;
import com.tencent.xinge.bean.MessageIOS;
import com.tencent.xinge.bean.MessageType;
import com.tencent.xinge.bean.Platform;
import com.tencent.xinge.push.app.PushAppRequest;
import com.tencent.xinge.push.app.PushAppResponse;

@Service
public class XgPushService {

	private final Logger logger = LoggerFactory.getLogger(XgPushService.class);

	private AndroidXgPushConfig androidXgPushConfig;

	private IOSXgPushConfig iosXgPushConfig;

	@Autowired
	public XgPushService(AndroidXgPushConfig androidXgPushConfig, IOSXgPushConfig iosXgPushConfig) {
		this.androidXgPushConfig = androidXgPushConfig;
		this.iosXgPushConfig = iosXgPushConfig;
	}

	/**
	 * @param flag true:Android 设备 false:iOS 设备
	 * @param title 推送标题
	 * @param content 推送内容
	 * @param deviceToken 设备唯一编号
	 * @return boolean
	 * @Title: xgPush
	 * @Description: 发送 信鸽推送消息
	 */
	public boolean xgPush(boolean flag, String title, String content, String deviceToken) {
		PushAppResponse response = this.sendSingleDeviceReminder(flag, title, content, deviceToken);
		// 调用成功后执行
		if (response.getRet_code() == 0) {
			logger.info("true");
			return true;
		} else {
			// 调用失败时执行
			logger.info("XgPush request failure.");
			logger.info("return err_msg: " + response.getErr_msg());
			return false;
		}
	}

	/**
	 * @return PushAppResponse
	 * @Title: sendSingleDeviceReminder
	 * @Description: 统一调用 信鸽推送
	 */
	private PushAppResponse sendSingleDeviceReminder(boolean flag, String title, String content,
			String deviceToken) {
		String access_id = null, secret_key = null;

		// 分解成 第一部分：获取配置参数
		// 区分 Android | IOS 设备类型
		if (flag) {
			// 获取 Android 的 信鸽 配置 参数
			access_id = androidXgPushConfig.getAccess_id();
			secret_key = androidXgPushConfig.getAccess_key();
		} else {
			// 获取 iOS 的 信鸽 配置 参数
			access_id = iosXgPushConfig.getAccess_id();
			secret_key = iosXgPushConfig.getAccess_key();
		}
		logger.info("access_id : " + access_id + "\t secret_key: \t" + secret_key);

		// 分解成第二部分：调用信鸽推送 Restful API,返回调用后的返回结果
		// 调用 信鸽
		XingeApp xingeApp = new XingeApp(access_id, secret_key);

		// 推送的信息
		Message message = new Message();
		// 推送标题
		message.setTitle(title);
		// 推送内容
		message.setContent(content);

		PushAppRequest pushAppRequest = new PushAppRequest();
		// 推送目标
		pushAppRequest.setAudience_type(AudienceType.token);
		// 客户端平台类型
		pushAppRequest.setPlatform(Platform.android);

		// 推送目标
		pushAppRequest.setAudience_type(AudienceType.token);
		// 客户端平台类型
		pushAppRequest.setPlatform(Platform.android);
		// 消息类型
		pushAppRequest.setMessage_type(MessageType.notify);

		// 单设备 dvice_token 编号
		ArrayList<String> tokenList = new ArrayList<String>();
		tokenList.add(deviceToken);
		pushAppRequest.setToken_list(tokenList);

		// 请求参数实体类
		PushAppRequest json = new PushAppRequest();
		if (flag) {
			json = this.sendAndroidSingleDeviceReminder(message, pushAppRequest);
		} else {
			json = this.sendIOSSingleDeviceReminder(message, pushAppRequest);
		}

		// 推送传递参数
		String jsonRequest = com.alibaba.fastjson.JSONObject.toJSONString(json);
		// 调用推送接口
		JSONObject result = xingeApp.pushApp(jsonRequest);

		// 返回结果 由 JSONObject 转换为 实体类
		PushAppResponse response = CustomJsonUtil.json2Bean(result, PushAppResponse.class);
		return response;
	}

	/**
	 * @description 信鸽 发送 Android 推送消息
	 */
	public PushAppRequest sendAndroidSingleDeviceReminder(Message message,
			PushAppRequest pushAppRequest) {
		logger.info("Android xinge push in.");

		Map<String, Object> custom = new HashMap<String, Object>();
		custom.put("vibrate", 1);

		String customJsonStr = com.alibaba.fastjson.JSONObject.toJSONString(custom);

		MessageAndroid android = new MessageAndroid();
		android.setBuilder_id(0);
		android.setCustom_content(customJsonStr);
		logger.info("Android custom : \t" + customJsonStr);

		message.setAndroid(android);
		// Message
		pushAppRequest.setMessage(message);
		logger.info("Android xinge push out.");
		logger.info("Android return : \t " + pushAppRequest);
		return pushAppRequest;
	}

	/**
	 * @description 信鸽 发送 iOS 推送消息
	 */
	public PushAppRequest sendIOSSingleDeviceReminder(Message message,
			PushAppRequest pushAppRequest) {
		logger.info("IOS xinge push in.");

		MessageIOS messageIOS = new MessageIOS();

		Alert alert = new Alert();
		// iOS 信息标题
		alert.setTitle(message.getTitle());
		// iOS 信息内容
		alert.setBody(message.getContent());

		Aps aps = new Aps();
		aps.setAlert(alert);
		// 可选参数
		// aps.setBadge(8);
		messageIOS.setAps(aps);

		// 设置 iOS 普通消息
		message.setIos(messageIOS);

		pushAppRequest.setMessage(message);
		logger.info("IOS xinge push out.");
		logger.info("IOS return ： \t" + pushAppRequest);
		return pushAppRequest;
	}
}
