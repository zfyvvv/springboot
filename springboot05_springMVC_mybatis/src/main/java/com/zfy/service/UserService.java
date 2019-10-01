package com.zfy.service;

import java.util.List;

import com.zfy.pojo.Users;

public interface UserService {

	void addUser(Users users);
	List<Users> findUserAll();
	void deleteUser(Integer index);
}
