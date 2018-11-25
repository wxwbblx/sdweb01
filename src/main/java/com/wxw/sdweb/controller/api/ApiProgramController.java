package com.wxw.sdweb.controller.api;


import java.util.Date;
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
import com.wxw.sdweb.service.IProgramService;
import com.wxw.sdweb.util.ResultUtils;
import com.wxw.sdweb.vo.Program;

@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ApiProgramController {
	@Autowired
	private IProgramService programService;

	@SuppressWarnings("rawtypes")
	@RequestMapping("/api/v1/programs/getall/")
	public Result objslist() {
		List<Program> objs = programService.findAll();
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/api/v1/programs/getcurrlist", method = RequestMethod.GET)
	public Result getCurrList() {
		String pdate = new java.sql.Date(new Date().getTime()).toString();  
		List<Program> objs = programService.findByDate(pdate);
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/api/v1/programs/getdate/{pdate}", method = RequestMethod.GET)
	public Result objslist(@PathVariable("pdate") String pdate) {
		List<Program> objs = programService.findByDate(pdate);
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/api/v1/programs/getnew", method = RequestMethod.GET)
	public Result objsnewlist() {
		List<Program> objs = programService.findByIsnew(1);
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/api/v1/programs/getnew/{isnew}", method = RequestMethod.GET)
	public Result objsnewlist(@PathVariable("isnew") int isnew) {
		List<Program> objs = programService.findByIsnew(isnew);
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}
}
