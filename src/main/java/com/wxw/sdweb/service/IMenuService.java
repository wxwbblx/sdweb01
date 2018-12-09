package com.wxw.sdweb.service;

import java.util.List;

import com.wxw.sdweb.vo.Menu;

public interface IMenuService {
	List<Menu> findAll();

	Menu findById(int id);

	int delete(int id);

	
}
