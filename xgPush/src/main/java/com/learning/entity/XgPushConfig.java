package com.learning.entity;

public class XgPushConfig extends PushConifg {

	private static final long serialVersionUID = 1L;

	/**
	 * @script 应用唯一标识，可在xg.qq.com管理台查看
	 */
	public static Long ACCESS_ID;

	/**
	 * @script 1.unix时间戳，用于确认请求的有效期 2.与服务器时间（北京时间）偏差大于valid_time,请求会被拒绝
	 */
	public static String TIMESTAMP;

	/**
	 * @script 1.配合timestamp确定请求的有效期 2.单位为秒 3.最大值为600 4.不传或者小于0 或者大于600 都会被设置600
	 * @Required false
	 */
	public static String VALID_TIME;

	/**
	 * @script: 接口秘钥
	 * @Required false
	 */
	public static String SECRET_KEY;

	/**
	 * @script: iOS环境: 生产环境：1 开发环境：2
	 * @Required true(仅 iOS)
	 */
	public static int IOS_ENVIRONMENT;
}
