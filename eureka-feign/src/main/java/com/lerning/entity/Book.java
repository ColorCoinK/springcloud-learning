package com.lerning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title null.java$
 * @ClassName Book
 * @Description TODO
 * @Author sanss
 * @Date 2019/2/14 10:46
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	private Long id;

	private String name;

	private Double price;


}