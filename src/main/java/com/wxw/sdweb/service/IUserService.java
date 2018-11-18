package com.wxw.sdweb.service;

import java.util.List;
import java.util.Optional;

import com.wxw.sdweb.vo.User;

public interface IUserService {
	
	
	List<User> findAllUser();
	
	User find(int id);
	
	int delete(int id);
	
	User login(String userid);
	
	/**
	 * 新增、编辑、保存用户
	 * @param user
	 * @return
	 *//*
	User saveOrUpdateUser(User user);
	
	*//**
	 * 
	 * @param user
	 * @return
	 *//*
	User registerUser(User user);
	
	*//**
	 * 根据ID删除用户
	 * @param id
	 *//*
	void removeUser(Long id);
	
	*//**
	 * 根据ID获取用户
	 * @param id
	 * @return
	 *//*
	Optional<User> getUserById(Long id);*/
}
