package com.zfy.mapper;

import java.util.List;

import com.zfy.pojo.Users;

public interface UsersMapper {
	
	void insertUser(Users users);
	List<Users> selUserAll();
	void delUserById(Integer index);
}
