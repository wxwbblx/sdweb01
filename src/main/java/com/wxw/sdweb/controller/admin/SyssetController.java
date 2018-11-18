package com.wxw.sdweb.controller.admin;

import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SyssetController {

	@RequestMapping(value = "/admin/about")
	@ResponseBody
	public ModelAndView load(Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("/admin/sysset/about");
		map.put("pagetitle", "关于我们");
		map.put("title", "关于我们");
		map.put("copyright", "Copyright 2018 by wxw. All rights reserved.");
		return mv;

	}

}
