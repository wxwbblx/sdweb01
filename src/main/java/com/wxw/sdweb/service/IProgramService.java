package com.wxw.sdweb.service;

import java.util.List;

import com.wxw.sdweb.vo.Program;

public interface IProgramService {
	List<Program> findAll();

	Program find(int id);

	int delete(int id);

	int insert(Program program);

	int update(Program program);
}
