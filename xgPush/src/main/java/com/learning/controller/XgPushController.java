package com.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.service.XgPushService;

/**
 * @ClassName: XgPushController
 * @Description: 信鸽推送
 * @Created by luohui on 2018/08/25
 */
@RestController
@RequestMapping(value = "push")
public class XgPushController {

	private final static Logger logger = LoggerFactory.getLogger(XgPushController.class);

	private XgPushService xgPushService;

	@Autowired
	public XgPushController(XgPushService xgPushService) {
		this.xgPushService = xgPushService;
	}

	@GetMapping(value = "centerSheet/{id}")
	public Object reminder(@PathVariable(value = "id") Long sheetId) {
		/**
		 Map<String, Object> content = new HashMap<String, Object>();
		 AndroidPushMessageVO message = new AndroidPushMessageVO("测试推送消息", "来自信鸽的测试推送消息");
		 content.put("vibrate", 1);
		 message.setCustom_content(content);
		 // 设备单推
		 String URI = "http://openapi.xg.qq.com/v2/push/single_device";
		 pushConfig.setTimestamp(System.currentTimeMillis() + "");

		 XgSignUtil.createSign("GET", URI, message, "", pushConfig);
		 */

		return xgPushService.sendSingleDeviceReminder(sheetId);
	}

}
