package com.wxw.sdweb.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.wxw.sdweb.vo.Advert;

@ComponentScan({ "com.wxw.sdweb.mapper" })
@Service(value = "advertService")
public interface IAdvertService {

	List<Advert> findAll();

	Advert find(int id);

	int delete(int id);

	int insert(Advert obj);

	int update(Advert obj);
}
