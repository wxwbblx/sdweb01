package com.wxw.sdweb.service;

import java.util.List;

import com.wxw.sdweb.vo.Program;

public interface IProgramService {
	List<Program> findAll();

	List<Program> findByDate(String pdate);

	List<Program> findByIsnew(int isnew);

	Program find(int id);

	int delete(int id);

	int insert(Program program);

	int update(Program program);
}
