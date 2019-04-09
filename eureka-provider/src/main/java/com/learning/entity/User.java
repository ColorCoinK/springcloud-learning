package com.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

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