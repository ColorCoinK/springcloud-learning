package com.learning.entity;

/**
 * Cors 测试实体类
 *
 * @ClassName: Greeting
 * @Description: TODO
 * @Created by luohui on 2018/07/20
 */
public class Greeting {

	private final long id;
	private final String content;

	public Greeting() {
		this.id = -1;
		this.content = "";
	}

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

}
