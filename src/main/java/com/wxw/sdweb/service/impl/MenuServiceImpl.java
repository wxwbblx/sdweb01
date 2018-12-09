package com.wxw.sdweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.wxw.sdweb.dao.MenuMapper;
import com.wxw.sdweb.service.IMenuService;
import com.wxw.sdweb.vo.Menu;

@ComponentScan({ "com.wxw.sdweb.mapper" })
@Service(value = "menuService")
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private MenuMapper menuDao;

	@Override
	public List<Menu> findAll() {
		List<Menu> menus = menuDao.findAll();
		return menus;
	}

	@Override
	public int delete(int id) {
		int row = menuDao.delete(id);
		return row;
	}

	@Override
	public Menu findById(int id) {
		List<Menu> objs = menuDao.findById(id);
		Menu obj=null;
		if(objs.size()>0)
		{
			obj=objs.get(0);
		}
		System.out.println("aaaaaaaa:"+objs.size());
		return obj;
	}



}
