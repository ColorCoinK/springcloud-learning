package com.learning.util;

import org.json.JSONObject;

import com.google.gson.Gson;

/**
 * @description:自定义Json工具类
 * @createBy luohui 2018/08/26
 */
public class CustomJsonUtil {

	public static <T> T json2Bean(String json, Class<T> clazz) {
		Gson gson = new Gson();
		return gson.fromJson(json, clazz);
	}


	public static <T> T json2Bean(JSONObject object, Class<T> clazz) {
		String json = JSONObject.valueToString(object);
		Gson gson = new Gson();
		return gson.fromJson(json, clazz);
	}
}
