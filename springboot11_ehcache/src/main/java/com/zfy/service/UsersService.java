package com.zfy.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zfy.pojo.Users;

public interface UsersService {
	void saveUser(Users users);
	List<Users> findUserAll();
	Users findUserById(Integer id);
	Page<Users> findUserByPage(Pageable pageable);
}
