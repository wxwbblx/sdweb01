package com.wxw.sdweb.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wxw.sdweb.vo.User;


@Mapper
public interface UserMapper01 {
	
	@Insert("")
	public void insert(User user);

	@Update("")
    public void update(User user);
    @Delete("")
    public void delete(int id);
    
    @Select("select * from user where id  = #{id}")
    public User find(int id);
    
    @Select("select * from user where userid  = #{userid}")
    public User findbyName(String name);
    
}
