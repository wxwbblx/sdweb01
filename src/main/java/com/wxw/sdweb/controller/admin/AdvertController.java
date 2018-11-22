package com.wxw.sdweb.controller.admin;

import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AdvertController {

	
	@RequestMapping(value = "/admin/ad/load", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView load(Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("/admin/advert/advertlist");
		map.put("pagetitle", "管理员登录");
		map.put("title", "三砥后台管理系统V1.00");
		map.put("copyright", "Copyright 2018 by wxw. All rights reserved.");
		return mv;
	}
}
