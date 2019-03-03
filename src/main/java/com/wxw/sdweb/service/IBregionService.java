package com.wxw.sdweb.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.wxw.sdweb.vo.Bregion;

@ComponentScan({ "com.wxw.sdweb.mapper" })
@Service(value = "advertService")
public interface IBregionService {

	List<Bregion> findAll();

	int delete(int id);

	int insert(Bregion obj);

	int update(Bregion obj);
}
