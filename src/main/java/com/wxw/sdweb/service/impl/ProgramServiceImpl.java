package com.wxw.sdweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.wxw.sdweb.dao.ProgramMapper;
import com.wxw.sdweb.service.IProgramService;
import com.wxw.sdweb.vo.Program;

@ComponentScan({ "com.wxw.sdweb.mapper" })
@Service(value = "programService")
public class ProgramServiceImpl implements IProgramService {

	@Autowired
	private ProgramMapper programDao;

	@Override
	public List<Program> findAll() {
		List<Program> objs = programDao.findAll();
		return objs;
	}

	@Override
	public Program find(int id) {
		Program obj = programDao.find(id);
		return obj;
	}

	@Override
	public int delete(int id) {
		return programDao.delete(id);
	}

	@Override
	public int insert(Program program) {
		return programDao.insert(program);
	}

	@Override
	public int update(Program program) {
		return programDao.update(program);
	}

	@Override
	public List<Program> findByDate(String pdate) {
		List<Program> objs = programDao.findBydate(pdate);
		return objs;
	}

}
