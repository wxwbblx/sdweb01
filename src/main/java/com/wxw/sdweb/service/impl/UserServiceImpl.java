package com.wxw.sdweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.wxw.sdweb.dao.UserMapper;
import com.wxw.sdweb.service.IUserService;
import com.wxw.sdweb.vo.User;

@ComponentScan({ "com.wxw.sdweb.mapper" })
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userDao;

	@Override
	public List<User> findAllUser() {
		List<User> users = userDao.findAllUser();
		return users;
	}

	@Override
	public User find(int id) {
		User user = userDao.find(id);
		return user;
	}

	@Override
	public int delete(int id) {
		int row = userDao.delete(id);
		return row;
	}

	@Override
	public User login(String userid) {
		User user = userDao.login(userid);
		return user;
	}

	/*
	 * @Resource private UserMapper userMapper;
	 * 
	 * @Override public User saveOrUpdateUser(User user) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public User registerUser(User user) { userMapper.insert(user);
	 * return null; }
	 * 
	 * @Override public void removeUser(Long id) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public Optional<User> getUserById(Long id) { // TODO Auto-generated
	 * method stub return null; }
	 */

}
