package com.wxw.sdweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wxw.sdweb.vo.User;

@Mapper
public interface UserMapper {
	@Select("select * from user ")
	public List<User> findAllUser();
	
	@Select("select * from user where id  = #{id}")
    public User find(int id);
	
	@Select("select * from user where userid  = #{userid}")
	public User login(String userid);
	
	@Delete("delete from user where id  = #{id}")
    public int delete(int id);
	
	
	@Insert("")
	public int insert(User user);

	@Update("")
    public int update(User user);
	
}
