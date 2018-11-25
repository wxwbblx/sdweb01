package com.wxw.sdweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wxw.sdweb.vo.Advert;

@Mapper
public interface AdvertMapper {

	@Select("select * from  Advert order by adtime desc")
	public List<Advert> findAll();
	
	@Select("select * from Advert where adpage  = #{adpage} and isenable='1'")
	public List<Advert> findByPage(String adpage);

	@Select("select * from Advert where id  = #{id}")
	public Advert find(int id);

	@Select("select * from Advert where adname  = #{adname}")
	public Advert findbyname(String mname);

	@Delete("delete from Advert where id  = #{id}")
	public int delete(int id);

	@Update("update Advert set adname=#{adname},adtitle=#{adtitle},adtype=#{adtype},adurl=#{adurl},adtime=#{adtime},adpage=#{adpage},isenable=#{isenable},remark#{remark}  from  where id  = #{id}")
	public int update(Advert obj);

	@Insert("insert into advert " + "(adname,adtitle,adtype,adurl,adtime,adpage,isenable,remark) "
			+ "values( #{adname},#{adtitle},#{adtype},#{adurl},#{adtime},#{adpage},#{isenable},#{remark})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Advert obj);
}
