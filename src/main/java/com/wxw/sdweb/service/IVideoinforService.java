package com.wxw.sdweb.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wxw.sdweb.vo.Videoinfor;

public interface IVideoinforService {
	public List<Videoinfor> findByVid(int vid);
}
