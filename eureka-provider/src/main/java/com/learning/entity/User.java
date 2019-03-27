package com.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @Title null.java$
 * @ClassName User
 * @Description TODO
 * @Author sanss
 * @Date 2019/2/14 9:38
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "t_user")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private Integer age;

}