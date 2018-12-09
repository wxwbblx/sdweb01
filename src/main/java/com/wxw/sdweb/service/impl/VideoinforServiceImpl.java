package com.wxw.sdweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.wxw.sdweb.dao.VideoinforMapper;
import com.wxw.sdweb.service.IVideoinforService;
import com.wxw.sdweb.vo.Videoinfor;
@ComponentScan({ "com.wxw.sdweb.mapper" })
@Service(value = "videoinforService")
public class VideoinforServiceImpl implements IVideoinforService {

	@Autowired
	private VideoinforMapper videoinforDao;
	
	@Override
	public List<Videoinfor> findByVid(int vid) {
		return videoinforDao.findByVid(vid);
	}

}
