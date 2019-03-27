package com.learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.vo.UserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Created by luohui on 2018/07/18
 */
@Api(tags = {"用户管理"})
@RestController
@RequestMapping(value = "/user")
public class UserController {

	/**
	 * 获取用户list
	 */
	@ApiOperation("获取用户相关信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "userName", dataType = "String", required = true, value = "用户的姓名", defaultValue = "张飞"),
			@ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "wangga")})
	@ApiResponses({@ApiResponse(code = 400, message = "请求参数错误"),
			@ApiResponse(code = 404, message = "请求路径没有或者页面跳转路径错误")})
	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	public List<UserVO> getUser(@RequestParam("userName") String userName,
			@RequestParam("password") String password) {

		System.out.print("logger.in:getUser---------");

		UserVO info = new UserVO("test01", "测试账户一", "士兵");
		UserVO info2 = new UserVO("test02", "测试账户二", "将领");
		UserVO info3 = new UserVO("test03", "测试账户三", "元帅");

		List<UserVO> list = new ArrayList<>();
		list.add(info);
		list.add(info2);
		list.add(info3);

		return list;
	}

	/**
	 * 查询用户详细信息
	 */
	@ApiOperation(value = "查询用户详细信息")
	@ApiImplicitParam(paramType = "path", name = "id", dataType = "long", required = true, value = "用户id", defaultValue = "1")
	@ApiResponses({@ApiResponse(code = 400, message = "请求参数错误"),
			@ApiResponse(code = 404, message = "请求路径没有或者页面跳转路径错误")})
	@RequestMapping(value = "queryUserInfo/{id}", method = RequestMethod.GET)
	public Object queryUserInfo(@PathVariable("id") Long id) {
		UserVO info = new UserVO("士兵" + id, "00" + id, "张三" + id);
		return info;
	}

	/**
	 * 修改用户信息
	 */
	@ApiOperation(value = "修改用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "id", dataType = "long", required = true, value = "用户id", defaultValue = "1"),
			@ApiImplicitParam(paramType = "body", name = "User", dataType = "User", value = "修改的用户信息")})
	@ApiResponses({@ApiResponse(code = 400, message = "请求参数错误"),
			@ApiResponse(code = 404, message = "请求路径没有或者跳转页面错误")})
	@RequestMapping(value = "modifyUserInfo", method = RequestMethod.POST)
	public Object modifyUserInfo(@RequestParam("id") Long id, @RequestBody UserVO UserVO) {
		System.out.print("-----------modifyUserInfo:" + UserVO.toString());
		UserVO.setAccount(++id + "");
		return UserVO;
	}

	/**
	 * 删除用户信息
	 */
	@ApiOperation(value = "删除用户信息")
	@ApiImplicitParam(paramType = "path", name = "id", dataType = "long", required = true, value = "用户id", defaultValue = "1")
	@ApiResponses({@ApiResponse(code = 400, message = "请求参数错误"),
			@ApiResponse(code = 404, message = "请求路径异常,或者跳转页面错误")})
	@RequestMapping(value = "delUserById/{id}", method = RequestMethod.DELETE)
	public String delUserById(@PathVariable(value = "id", required = true) Long id) {
		System.err.print("-----del");
		return "success";
	}

}
