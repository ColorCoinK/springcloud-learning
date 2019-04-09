package com.learning.entity.dto;

import com.learning.entity.UserPO;
import lombok.Data;

/**
 * @Title token 刷新时间数据传输实体类
 * @ClassName UserDo
 * @Description TODO
 * @Author sanss
 * @Date 2019/2/22 16:24
 * @Version 1.0
 */
@Data
public class UserDto extends UserPO {

	/**
	 * 有效时长(unix 时间戳)
	 **/
	private Long expritaion;

	private String token;

	public UserDto() {
		this.expritaion = (long) 1000 * 60 * 10;
	}

	public UserDto(String token, Long id, String name) {
		this.token = token;
		this.setId(id);
		this.setName(name);
	}
}