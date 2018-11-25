package com.wxw.sdweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.wxw.sdweb.dao.AdvertMapper;
import com.wxw.sdweb.service.IAdvertService;
import com.wxw.sdweb.vo.Advert;
import com.wxw.sdweb.vo.Menu;
@ComponentScan({ "com.wxw.sdweb.mapper" })
@Service(value = "advertService")
public class AdvertServiceImpl implements IAdvertService {

	@Autowired
	private AdvertMapper  advertDao;
	
	
	@Override
	public List<Advert> findAll() {
		List<Advert> objs = advertDao.findAll();
		return objs;
	}

	@Override
	public Advert find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		return advertDao.delete(id);
	}

	@Override
	public int insert(Advert obj) {
		// TODO Auto-generated method stub
		return  advertDao.insert(obj);
	}

	@Override
	public int update(Advert obj) {
		// TODO Auto-generated method stub
		return advertDao.update(obj);
	}

	@Override
	public List<Advert> findByPage(String adpage) {
		List<Advert> objs = advertDao.findByPage(adpage);
		return objs;
	}

}
