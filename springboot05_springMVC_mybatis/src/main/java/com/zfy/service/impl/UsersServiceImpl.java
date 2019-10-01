package com.zfy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfy.mapper.UsersMapper;
import com.zfy.pojo.Users;
import com.zfy.service.UserService;

@Service
@Transactional   //事务，该类下所有的方法都是事务控制的
public class UsersServiceImpl implements UserService{
	
	@Autowired
	private UsersMapper usersMapper;

	@Override
	public void addUser(Users users) {
		usersMapper.insertUser(users);
	}

	@Override
	public List<Users> findUserAll() {
		List<Users> list=usersMapper.selUserAll();
		return list;
	}

	@Override
	public void deleteUser(Integer index) {
		// TODO Auto-generated method stub
		usersMapper.delUserById(index);
	}
}
