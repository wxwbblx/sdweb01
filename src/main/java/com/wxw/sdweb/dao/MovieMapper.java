package com.wxw.sdweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.wxw.sdweb.vo.Movie;

@Mapper
public interface MovieMapper {

	@Select("select * from  movie ") // order by pstime asc
	public List<Movie> findAll();

	@Select("select * from movie where pdate  = #{pdate}  order by pstime asc")
	public List<Movie> findBydate(String pdate);

	@Select("select * from movie where isnew  = #{isnew}  order by pstime asc")
	public List<Movie> findIsNew(int isnew);

	@Select("select * from  movie where ptype=#{ptype} order by pstime asc")
	public List<Movie> findByType(String ptype);

	@Insert("insert into movie (vname,vtype,ptype,vtime,releasetime,region,"
			+ "director,tostar,synopsis,poster,vurl,isnew,ishot,isnominate,sylloge,updatetext,remark) " + "values"
			+ "(#{vname},#{vtype},#{ptype},#{vtime},#{releasetime},#{region},"
			+ "#{director},#{tostar},#{synopsis},#{poster},#{vurl},#{isnew},#{ishot},#{isnominate},#{sylloge},#{updatetext},#{remark})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Movie movie);

	@Delete("delete from movie where id  = #{id}")
	public int delete(int id);

}
