package com.zfy.test;


import java.util.Set;

import javax.management.relation.Role;
import javax.management.relation.RoleList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zfy.App;
import com.zfy.pojo.Users;
import com.zfy.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={App.class})
public class ServiceTest {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	/*
	 * 添加
	 */
	@Test
	public void testSave() {
		Users users=new Users();
		users.setName("小红");
		users.setAge(21);
		
		Users users2=new Users();
		users2.setName("小黑");
		users2.setAge(22);
		
		Users users3=new Users();
		users3.setName("小绿");
		users3.setAge(23);
		
		Users users4=new Users();
		users4.setName("小白");
		users4.setAge(24);
		
		this.userServiceImpl.saveUser(users);
		this.userServiceImpl.saveUser(users2);
		this.userServiceImpl.saveUser(users3);
		this.userServiceImpl.saveUser(users4);
	}
	
	@Test
	public void testFindUserById() {
		System.out.println(this.userServiceImpl.findUserById(2));
		System.out.println(this.userServiceImpl.findUserById(2));
	}
	/*
	 * 测试Cacheable，
	 */
	@Test
	public void testFindUserByPage() {
		Pageable pageable=new PageRequest(0, 2);
		System.out.println(this.userServiceImpl.findUserByPage(pageable));
		System.out.println(this.userServiceImpl.findUserByPage(pageable));
	}
	
	/*
	 * 测试@CacheEvict
	 */
	@Test
	public void testFindUserAll() {
		System.out.println(this.userServiceImpl.findUserAll());
		
		Users users=new Users();
		users.setName("小青");
		users.setAge(29);
		this.userServiceImpl.saveUser(users);
		
		System.out.println(this.userServiceImpl.findUserAll());
		
	}
}
