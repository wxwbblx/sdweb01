package com.wxw.sdweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wxw.sdweb.vo.Movie;

@Mapper
public interface MovieMapper {

	@Select("select * from  movie order by sorta asc ") // order by pstime asc
	public List<Movie> findAll();

	@Select("select * from  movie where ptype=#{ptype}  order by sorta asc") // order by pstime asc
	public List<Movie> findByptype(String ptype);

	@Select("select * from  movie where ptype=#{ptype} and isnew=#{isnew}  order by sorta asc") // order by pstime asc
	List<Movie> findBynewptype(@Param("ptype") String ptype, @Param("isnew") int isnew);

	@Select("select * from  movie where ptype=#{ptype} and ishot=#{ishot}  order by sorta asc") // order by pstime asc
	List<Movie> findByhotptype(@Param("ptype") String ptype, @Param("ishot") int ishot);

	@Select("select * from  movie where ptype=#{ptype} and isnominate=#{isnominate}  order by sorta asc") // order by pstime asc
	List<Movie> findBynominateptype(@Param("ptype") String ptype, @Param("isnominate") int isnominate);

	@Select("select * from  movie where id=#{id}  order by sorta asc") // order by pstime asc
	public Movie findById(@Param("id") int id);

	@Select("select * from movie where pdate  = #{pdate}  order by pstime asc   ")
	public List<Movie> findBydate(String pdate);

	@Select("select * from movie where isnew  = #{isnew}  order by pstime asc")
	public List<Movie> findIsNew(int isnew);

	@Select("select * from  movie where ptype=#{ptype} order by pstime asc")
	public List<Movie> findByType(String ptype);

	@Insert("insert into movie (vname,vtype,ptype,vtime,releasetime,region,"
			+ "director,tostar,synopsis,poster,vurl,isnew,ishot,isnominate,sylloge,updatetext,sorta,remark) " + "values"
			+ "(#{vname},#{vtype},#{ptype},#{vtime},#{releasetime},#{region},"
			+ "#{director},#{tostar},#{synopsis},#{poster},#{vurl},#{isnew},#{ishot},#{isnominate},#{sylloge},#{updatetext},#{sorta},#{remark})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Movie movie);

	@Delete("delete from movie where id  = #{id}")
	public int delete(int id);

	@Update("update movie set vname=#{vname},vtype=#{vtype},ptype=#{ptype},vtime=#{vtime},releasetime=#{releasetime},region=#{region},"
			+ "director=#{director},tostar=#{tostar},synopsis=#{synopsis},poster=#{poster},vurl=#{vurl},isnew=#{isnew},ishot=#{ishot},"
			+ "isnominate=#{isnominate},sylloge=#{sylloge},updatetext=#{updatetext},sorta=#{sorta},remark=#{remark} where id=#{id}")
	public int update(Movie movie);

}
