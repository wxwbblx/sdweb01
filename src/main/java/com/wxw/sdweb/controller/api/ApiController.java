package com.wxw.sdweb.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wxw.sdweb.Result;
import com.wxw.sdweb.enums.ResultCode;
import com.wxw.sdweb.service.IUserService;
import com.wxw.sdweb.util.ResultUtils;
import com.wxw.sdweb.vo.User;

@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
// @RequestMapping("/api/v1")
public class ApiController {

	@Autowired
	private IUserService userService;
	
	

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/api/v1/login", method = RequestMethod.GET)
	// http://localhost:8080/api/v1/login?uname=wxw&upwd=www
	public Result login(@RequestParam("uname") String uname, @RequestParam("upwd") String upwd) {
		String pwd = upwd;

		User user = userService.login(uname);

		if (null != user) {
			if (!pwd.equals(user.getPassword())) {
				return ResultUtils.warn(ResultCode.PASSWORD_ERROR);
			} else {
				return ResultUtils.success(user);
			}
		} else {
			return ResultUtils.warn(ResultCode.PASSWORD_ERROR);
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/api/v1/getUsers")
	public Result userlist() {
		List<User> users = userService.findAllUser();
		if (null != users) {
			return ResultUtils.success(users);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}
}
