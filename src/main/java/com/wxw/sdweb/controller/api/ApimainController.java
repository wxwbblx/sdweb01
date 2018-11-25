package com.wxw.sdweb.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wxw.sdweb.Result;
import com.wxw.sdweb.enums.ResultCode;
import com.wxw.sdweb.service.IAdvertService;
import com.wxw.sdweb.service.IMenuService;
import com.wxw.sdweb.util.ResultUtils;
import com.wxw.sdweb.vo.Advert;
import com.wxw.sdweb.vo.Menu;

@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ApimainController {
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IAdvertService advertServcie;
	
	/**
	 * 菜单获取
	 * 王宣武
	 * 2018-07-04
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/api/v1/getMenus")
	public Result menulist() {
		List<Menu> menus = menuService.findAll();
		if (null != menus) {
			return ResultUtils.success(menus);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	/**
	 * 广告获取
	 * 王宣武
	 * 2018-07-04
	 * @param adpage
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/api/v1/getAdvert/{adpage}", method = RequestMethod.GET)
	public Result advertlist(@PathVariable("adpage") String adpage) {
		List<Advert> objs = advertServcie.findByPage(adpage);
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}
	
	
	
	
	
	
	
}
