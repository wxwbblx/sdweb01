package com.wxw.sdweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wxw.sdweb.vo.Bregion;

@Mapper
public interface BregionMapper {
	
	@Select("select * from  bregion ") // order by pstime asc
	public List<Bregion> findAll();
	
	@Select("select * from Bregion where id  = #{id}")
	public Bregion findById(int id);

	@Insert("insert into bregion (lname,remark) " + "values"
			+ "(#{lname},#{remark})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Bregion bregion);

	@Delete("delete from Bregion where id  = #{id}")
	public int delete(int id);

	@Update("update bregion set lname=#{lname},remark=#{remark} where id=#{id}")
	public int update(Bregion bregion);

}
