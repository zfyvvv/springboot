package com.zfy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfy.dao.UserDao;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;
	
	public void addUser() {
		userDao.insertUser();
	}
}
