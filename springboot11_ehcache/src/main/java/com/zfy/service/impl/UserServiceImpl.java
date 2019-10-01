package com.zfy.service.impl;

import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zfy.dao.UsersRepository;
import com.zfy.pojo.Users;
import com.zfy.service.UsersService;

@Service
public class UserServiceImpl implements UsersService {
	@Autowired
	private UsersRepository usersRepository;

	@Override
	@CacheEvict(value="users",allEntries=true)
	public List<Users> findUserAll() {
		return usersRepository.findAll();
	}

	@Override
	//对当前查询的对象做缓存处理；
	@Cacheable(value="users")
	public Users findUserById(Integer id) {
		return usersRepository.findOne(id);
	}

	@Override
	@Cacheable(value="users",key="#pageable.Size")
	public Page<Users> findUserByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return usersRepository.findAll(pageable);
	}

	@Override
	public void saveUser(Users users) {
		// TODO Auto-generated method stub
		this.usersRepository.save(users);
	}

	
}
