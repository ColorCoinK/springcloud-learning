package com.learning.entity;

import java.io.Serializable;

/**
 * @ClassName: PushVO
 * @Description: 信鸽推送通用基础返回值
 * @Created by dew on 2018/08/25
 */
public class PushVO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 返回码
	/**
	 * {@link https://xg.qq.com/docs/server_api/v2/rest.html#返回码一览}
	 */
	private Integer ret_code;

	/**
	 * 结果描述
	 */
	private String err_msg;

	/**
	 * 请求正确时且有额外数据,则结果封装在该字段中
	 */
	private String result;

	public Integer getRet_code() {
		return ret_code;
	}

	public void setRet_code(Integer ret_code) {
		this.ret_code = ret_code;
	}

	public String getErr_msg() {
		return err_msg;
	}

	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "PushVO [ret_code=" + ret_code + ", err_msg=" + err_msg + ", result=" + result + "]";
	}

}
