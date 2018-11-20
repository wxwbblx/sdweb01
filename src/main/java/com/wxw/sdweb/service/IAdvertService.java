package com.wxw.sdweb.service;

import java.util.List;

import com.wxw.sdweb.vo.Advert;

public interface IAdvertService {

	List<Advert> findAll();

	Advert find(int id);

	int delete(int id);

	int insert(Advert obj);

	int update(Advert obj);
}
