package com.wxw.sdweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wxw.sdweb.vo.Menu;

@Mapper
public interface MenuMapper {

	/*
	 * @Autowired private String tname="menu";
	 */

	@Select("select * from  menu order by orders asc")
	public List<Menu> findAll();

	@Select("select * from menu where id  = #{id}")
	public Menu find(int id);

	@Select("select * from menu where mname  = #{mname}")
	public Menu findbyname(String mname);

	@Delete("delete from menu where id  = #{id}")
	public int delete(int id);
	
	@Update("update menu set  from  where id  = #{id}")
	public int update(int id);
}
