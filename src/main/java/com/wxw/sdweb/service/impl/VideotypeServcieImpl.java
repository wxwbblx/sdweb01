package com.wxw.sdweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.wxw.sdweb.dao.VideotypeMapper;
import com.wxw.sdweb.service.IVideotypeServcie;
import com.wxw.sdweb.vo.Videotype;

@ComponentScan({ "com.wxw.sdweb.mapper" })
@Service(value = "videotypeServcie")
public class VideotypeServcieImpl implements IVideotypeServcie {

	@Autowired
	private VideotypeMapper videotypeDao;

	@Override
	public List<Videotype> findAll() {
		// TODO Auto-generated method stub
		return videotypeDao.findAll();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return videotypeDao.delete(id);
	}

	@Override
	public int insert(Videotype videotype) {
		// TODO Auto-generated method stub
		return videotypeDao.insert(videotype);
	}

	@Override
	public int update(Videotype videotype) {
		// TODO Auto-generated method stub
		return videotypeDao.update(videotype);
	}

}
