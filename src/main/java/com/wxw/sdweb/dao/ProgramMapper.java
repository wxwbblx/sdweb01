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

	@Select("select * from program where id  = #{id}")
	public Program find(int id);

	@Select("select * from program where pname  = #{pname}")
	public Program findbyname(String pname);

	@Delete("delete from program where id  = #{id}")
	public int delete(int id);

	@Update("update program set pdate=#{pdate},pstime=#{pstime},pname=#{pname},plength=#{plength},purl=#{purl},remark=#{remark} from  where id  = #{id}")
	public int update(Program program);

	@Insert("insert into program (pdate,pstime,pname,plength,purl,remark) values( #{pdate},#{pstime},#{pname},#{plength},#{purl},#{remark})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Program program);
}
