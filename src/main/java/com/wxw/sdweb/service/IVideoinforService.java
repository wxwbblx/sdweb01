package com.wxw.sdweb.service;

import java.util.List;


import com.wxw.sdweb.vo.Videoinfor;

public interface IVideoinforService {
	public List<Videoinfor> findByVid(int vid);
	
	public Videoinfor findByVidid(int vid,String vname);

	int delete(int id);

	int insert(Videoinfor videoinfor);

	int update(Videoinfor videoinfor);
}
