package com.learning.entity.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户视图实体类
 *
 * @ClassName: UserVO
 * @Description: TODO
 * @Created by luohui on 2018/07/18
 */
@ApiModel(value = "用户实体类")
public class UserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "账户", required = true)
	private String account;

	@ApiModelProperty(value = "姓名", required = true)
	private String name;

	@ApiModelProperty(value = "昵称", required = true)
	private String nickName;

	public UserVO() {
	}

	public UserVO(String account, String name, String nickName) {
		this.account = account;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UserVO other = (UserVO) obj;
		if (account == null) {
			if (other.account != null) {
				return false;
			}
		} else if (!account.equals(other.account)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (nickName == null) {
			if (other.nickName != null) {
				return false;
			}
		} else if (!nickName.equals(other.nickName)) {
			return false;
		}
		return true;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "UserVO [account=" + account + ", name=" + name + ", nickName=" + nickName + "]";
	}

}
