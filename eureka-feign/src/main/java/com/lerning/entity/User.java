package com.lerning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title null.java$
 * @ClassName User
 * @Description TODO
 * @Author sanss
 * @Date 2019/2/14 9:38
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Long id;

	private String name;

	private Integer age;

}