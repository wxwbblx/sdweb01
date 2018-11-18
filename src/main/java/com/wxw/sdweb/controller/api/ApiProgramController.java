package com.wxw.sdweb.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/api/v1/getPrograms")
	public Result objslist() {
		List<Program> objs = programService.findAll();
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}
}
