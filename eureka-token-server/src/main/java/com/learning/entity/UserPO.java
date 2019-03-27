package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

/**
 * @Title 用户 —— 数据库映射实体类
 * @ClassName Account
 * @Description tbl_account
 * @Author sanss
 * @Date 2019/2/22 13:57
 * @Version 1.0
 */
@Entity
@Data
@ToString
@Table(name = "tbl_account")
public class UserPO {


	@Id
	@GeneratedValue
	private Long id;

	/**
	 * 姓名
	 **/
	private String name;

	/**
	 * 年龄
	 **/
	private Integer age;

	/**
	 * 性别
	 **/
	private String sex;

	/**
	 * 登录密码
	 **/
	private String password;

	/**
	 * 角色名称
	 **/
	private String role;


}