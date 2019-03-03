package com.wxw.sdweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wxw.sdweb.vo.Videotype;


@Mapper
public interface VideotypeMapper {

	@Select("select * from  videotype ") // order by pstime asc
	public List<Videotype> findAll();

	@Insert("insert into videotype (vtype,ptype,remark) " + "values"
			+ "(#{lname},#{remark})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Videotype videotype);

	@Delete("delete from videotype where id  = #{id}")
	public int delete(int id);

	@Update("update videotype set vtype=#{vtype},ptype=#{ptype},remark=#{remark} where id=#{id}")
	public int update(Videotype videotype);
}
