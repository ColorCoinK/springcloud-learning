package com.learning.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.PushConifg;
import com.learning.entity.PushVO;
import com.learning.entity.XgPushConfig;
import com.learning.entity.XgPushDTO;
import com.learning.util.CustomJsonUtil;
import com.tencent.xinge.Message;
import com.tencent.xinge.MessageIOS;
import com.tencent.xinge.XingeApp;

/**
 * @description: 信鸽推送实现的方法
 * @createBy luohui 2018/08/26
 */
@Service
public class XgPushService {

	private final static Logger logger = LoggerFactory.getLogger(XgPushService.class);

	private PushConifg pushConfig;

	@Autowired
	public XgPushService(PushConifg pushConifg) {
		this.pushConfig = pushConifg;
	}

	/**
	 * @description: 单个工单 催单
	 */
	public Object sendSingleDeviceReminder(Long sheetId) {

		// 查询 :工单信息详情,设置 XgPush 属性值
		XgPushDTO xgPushDTO = new XgPushDTO("测试推送消息", "来自信鸽的测试推送消息");
		xgPushDTO.setDevice_token("5af9eab6b434b5a7c8e75da9a7811bd98b49f584");

		// 设置信鸽 推送需要的通用基础参数
		XingeApp push = new XingeApp(XgPushConfig.ACCESS_ID, XgPushConfig.SECRET_KEY);

		JSONObject ret = new JSONObject();

		// 根据 device_token 区分 Android | iOS;调用不同的方法
		/**if ("Android".equals(xgPushDTO.getDevice_token())) {
		 // Android 推送
		 ret = this.sendAndroidReminder(xgPushDTO, push);
		 } else if ("iOS".equals(xgPushDTO.getDevice_token())) {
		 // iOS 推送
		 ret = this.sendIOSReminder(push, xgPushDTO);
		 }*/

		// ret = this.sendAndroidReminder(xgPushDTO, push);
		ret = this.sendIOSReminder(push, xgPushDTO);
		// 解析推送的返回结果
		PushVO result = CustomJsonUtil.json2Bean(ret, PushVO.class);

		// 返回码说明 ：https://xg.qq.com/docs/server_api/v2/rest.html#返回码一览
		if (result.getRet_code() == 0) {
			// 推送成功之后 执行的代码块
			logger.info("催单成功");
			return result;
		}
		// 推送失败之后执行的代码块
		logger.info("催单失败");
		return result;
	}

	/**
	 * 安卓 催单
	 */
	private JSONObject sendAndroidReminder(XgPushDTO xgPushDTO, XingeApp push) {

		// 信鸽推送 Demo line: 333
		Message message = new Message();
		// Message 自定义参数
		Map<String, Object> custom = new HashMap<>();
		custom.put("vibrate", 1);

		message.setType(Message.TYPE_NOTIFICATION);

		message.setTitle(xgPushDTO.getTitle());
		message.setContent(xgPushDTO.getBody());// Android 推送内容
		message.setCustom(custom);

		// 调用单个设备推送后结果返回
		JSONObject ret = push.pushSingleDevice(xgPushDTO.getDevice_token(), message);

		// 发送请求成功之后的操作
		logger.debug("安卓催单之后 返回结果: \t" + ret.toString());
		return ret;
	}

	/**
	 * iOS 催单
	 */
	private JSONObject sendIOSReminder(XingeApp push, XgPushDTO xgPushDTO) {
		// 信鸽推送 iOS 参数
		// XgPushDTO xgPushDTO = new XgPushDTO("ios title test", "ios body test");
		String alert = JSONObject.valueToString(xgPushDTO);

		// 信鸽推送 Demo.java line:362
		MessageIOS messageIOS = new MessageIOS();
		messageIOS.setType(MessageIOS.TYPE_APNS_NOTIFICATION);
		/*
		 * { "alert": { "title": "this is a title", "body": "this is content" } }
		 */
		messageIOS.setAlert(alert);
		// messageIOS.setBadge(1);
		// messageIOS.setCategory("INVITE_CATEGORY");
		// messageIOS.setSound("beep.wav");

		/**
		 // 自定义参数
		 Map<String, Object> custom = new HashMap<>();
		 custom.put("key1", "value1");
		 messageIOS.setCustom(custom);
		 */

		// 调用单个设备推送后的结果返回
		JSONObject ret = push.pushSingleDevice(xgPushDTO.getDevice_token(), messageIOS,
				pushConfig.getIos_environment());
		logger.info("iOS 催单之后返回" + ret.toString());
		return ret;
	}

	public Object sendAllReminder(Long[] sheetIds) {

		// 查询 工单序号
		List<XgPushDTO> xgList = new ArrayList<>();
		for (XgPushDTO xg : xgList) {
			// 发送单个推送信息
		}

		return null;
	}

}
