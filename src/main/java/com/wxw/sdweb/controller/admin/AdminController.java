package com.wxw.sdweb.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wxw.sdweb.service.IUserService;
import com.wxw.sdweb.vo.User;

@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AdminController {

	// private String root_dir="";
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/admin/load", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView load(Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("/admin/login/login");
		map.put("pagetitle", "管理员登录");
		map.put("title", "三砥后台管理系统V1.00");
		map.put("copyright", "Copyright 2018 by wxw. All rights reserved.");
		return mv;
	}

	/**
	 * 主页面 王宣武
	 * 
	 * @param uname
	 * @param upwd
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/main", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView loadmain(@RequestParam("uname") String uname, @RequestParam("upwd") String upwd,
			Map<String, Object> map) {

		User user = userService.login(uname);
		if (checkUser(user, upwd).equals("ok")) {
			ModelAndView mv = new ModelAndView("/admin/main/main");
			map.put("title", "三砥后台管理系统--主页面 Ver1.00");
			map.put("user", uname);
			return mv;
		} else {
			ModelAndView mv=new ModelAndView("redirect:/admin/load");  //地址重定向
			return mv;
		}
	}

	private String checkUser(User user, String upwd) {
		String isok = "no";
		if (null != user) {
			if (upwd.equals(user.getPassword())) {
				isok ="ok";
			}
		}
		return isok;
	}

	/**
	 * 导航栏
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/nav", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadnav(Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("/admin/main/nav");
		return mv;
	}

	/**
	 * 首页
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadhome(Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("/admin/home/home");
		return mv;
	}

	/*
	 * @RequestMapping(value="/admin/main", method=RequestMethod.POST)
	 * 
	 * @ResponseBody public ModelAndView loadmain(@RequestBody Map<String,Object>
	 * reqMap,Map<String,Object> map) {
	 * 
	 * String aa=reqMap.get("uname").toString();
	 * 
	 * 
	 * ModelAndView mv = new ModelAndView("/admin/main/main"); map.put("title",
	 * "三砥后台管理系统--主页面 Ver1.00"); map.put("pagetitle", "管理员登录---"+aa); return mv; }
	 */

	/*
	 * @RequestMapping(value = "/login/v1/login/{id}", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public ModelAndView getLogin(Map<String, Object>
	 * map, @PathVariable String id) { ModelAndView mv = new
	 * ModelAndView("/login/login"); map = getLogin_01(map, id); return mv; }
	 */

	/*
	 * @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public ModelAndView login(Map<String, Object> map) {
	 * ModelAndView mv = new ModelAndView("/admin/login/login"); map.put("title",
	 * "用户登录页面"); return mv; }
	 */

	private Map<String, Object> getLogin_01(Map<String, Object> map, String id) {
		// Map<String, String> hashMap = new HashMap<>();
		// return new Result(ResultCode.SUCCESS, loginUser);
		map.put("msg", "登录成功");
		map.put("id", id);
		return map;
	}

}
