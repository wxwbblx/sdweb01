package com.wxw.sdweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.wxw.sdweb.dao.BregionMapper;
import com.wxw.sdweb.service.IBregionService;
import com.wxw.sdweb.vo.Bregion;

@ComponentScan({ "com.wxw.sdweb.mapper" })
@Service(value = "bregionService")
public class BregionServiceImpl implements IBregionService {

	@Autowired
	private BregionMapper bregionDao;

	@Override
	public List<Bregion> findAll() {
		// TODO Auto-generated method stub
		return bregionDao.findAll();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return bregionDao.delete(id);
	}

	@Override
	public int insert(Bregion bregion) {
		// TODO Auto-generated method stub
		return bregionDao.insert(bregion);
	}

	@Override
	public int update(Bregion bregion) {
		// TODO Auto-generated method stub
		return bregionDao.update(bregion);
	}

}
