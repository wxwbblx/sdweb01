package com.wxw.sdweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wxw.sdweb.vo.Program;

@Mapper
public interface ProgramMapper {

	@Select("select * from  program order by pstime asc")
	public List<Program> findAll();

	@Select("select * from program where pdate  = #{pdate}  order by pstime asc")
	public List<Program> findBydate(String pdate);

	@Select("select * from program where isnew  = #{isnew}  order by pstime asc")
	public List<Program> findIsNew(int isnew);
	

	@Select("select * from  program where ptype=#{ptype} order by pstime asc")
	public List<Program> findByType(String ptype);
	
	
	
	

	@Select("select * from program where id  = #{id}")
	public Program find(int id);

	@Select("select * from program where pname  = #{pname}")
	public Program findbyname(String pname);

	@Delete("delete from program where id  = #{id}")
	public int delete(int id);

	//@Update("update program set pdate=#{pdate,jdbcType=DATE},pstime=#{pstime,jdbcType=VARCHAR},pname=#{pname,jdbcType=VARCHAR},plength=#{plength,jdbcType=INTEGER},purl=#{purl,jdbcType=VARCHAR},remark=#{remark,jdbcType=VARCHAR},isnew=#{isnew,jdbcType=VARCHAR},ptype=#{ptype,jdbcType=VARCHAR} from where id = #{id}")
	
	@Update("update program set pdate=#{pdate},pstime=#{pstime},pname=#{pname},plength=#{plength},purl=#{purl},remark=#{remark},"
			+ "isnew=#{isnew},ptype=#{ptype} where id = #{id}")
	public int update(Program program);

	@Insert("insert into program (pdate,pstime,pname,plength,purl,isnew,ptype,remark) values( #{pdate},#{pstime},#{pname},#{plength},#{purl},#{isnew},#{ptype},#{remark})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Program program);
	
	
	
	
	
	
	
	
	
	
	
	
	
}
