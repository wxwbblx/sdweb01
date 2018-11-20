package com.wxw.sdweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wxw.sdweb.vo.Advert;


@Mapper
public interface AdvertMapper {
	
	@Select("select * from  Advert order by orders asc")
	public List<Advert> findAll();

	@Select("select * from Advert where id  = #{id}")
	public Advert find(int id);

	@Select("select * from Advert where adname  = #{adname}")
	public Advert findbyname(String mname);

	@Delete("delete from Advert where id  = #{id}")
	public int delete(int id);
	
	@Update("update Advert set  from  where id  = #{id}")
	public int update(int id);
}
