package com.wxw.sdweb.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wxw.sdweb.service.IAdvertService;
import com.wxw.sdweb.vo.Advert;

/***********************************************
 * 
 * 功能：Apimain主控制器 作者：王宣武 日期：2018-01-01
 * *********************************************
 */
@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AdvertController {

	@Autowired
	private IAdvertService advertService;

	/***********************************************
	 * 功能：广告API 作者：王宣武 日期：2018-01-01 
	 */

	/**
	 * 广告加载
	 * 王宣武
	 * 2018-01-01
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/ad/load", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView load(Map<String, Object> map) {

		List<Advert> objs = advertService.findAll();
		ModelAndView mv = new ModelAndView("/admin/advert/advertlist");
		map.put("title", "广告列表01");
		map.put("objs", objs);
		return mv;
	}

	public ModelAndView loadAdd(Map<String, Object> map) {
		List<Advert> objs = advertService.findAll();
		ModelAndView mv = new ModelAndView("/admin/advert/advertlist");
		map.put("title", "广告列表01");
		map.put("objs", objs);
		return mv;
	}
	
	
	
}
