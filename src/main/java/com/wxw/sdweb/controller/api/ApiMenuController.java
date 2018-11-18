package com.wxw.sdweb.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.wxw.sdweb.Result;
import com.wxw.sdweb.enums.ResultCode;
import com.wxw.sdweb.service.IMenuService;
import com.wxw.sdweb.util.ResultUtils;
import com.wxw.sdweb.vo.Menu;


@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ApiMenuController {
	
	@Autowired
	private IMenuService menuService;
	
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
}
