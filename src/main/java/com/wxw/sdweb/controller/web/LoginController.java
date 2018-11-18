package com.wxw.sdweb.controller.web;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wxw.sdweb.Result;
import com.wxw.sdweb.util.ResultUtils;
import com.wxw.sdweb.vo.User;

@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class LoginController {

	@RequestMapping(value = "/web/oad", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView load(Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("/login/login");
		map.put("title", "三砥前台管理系统V1.00");
		map.put("copyright", "Copyright 2018 by wxw. All rights reserved.");
		return mv;
	}
	
	@RequestMapping(value = "/web/login", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView login(Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("/login/login");
		map.put("title", "用户登录页面");
		return mv;
	}
	
	@RequestMapping(value = "/login/login/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getLogin(Map<String, Object> map, @PathVariable String id) {
		ModelAndView mv = new ModelAndView("/login/login");
		map = getLogin_01(map, id);
		return mv;
	}

	

	private Map<String, Object> getLogin_01(Map<String, Object> map, String id) {
		// Map<String, String> hashMap = new HashMap<>();
		// return new Result(ResultCode.SUCCESS, loginUser);
		map.put("msg", "登录成功");
		map.put("id", id);
		return map;
	}

	
}
