package com.wxw.sdweb.service;

import java.util.List;

import com.wxw.sdweb.vo.Videotype;

public interface IVideotypeServcie {

	List<Videotype> findAll();

	Videotype findById(int id);

	int delete(int id);

	int insert(Videotype obj);

	int update(Videotype obj);

}
