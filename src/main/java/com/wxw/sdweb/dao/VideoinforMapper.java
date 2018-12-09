package com.wxw.sdweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.wxw.sdweb.vo.Videoinfor;
@Mapper
public interface VideoinforMapper {
	@Select("select * from videoinfor where vid  = #{vid}  order by id asc")
	public List<Videoinfor> findByVid(int vid);
}
