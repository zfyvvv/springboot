package com.zfy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zfy.App;
import com.zfy.dao.UsersRepository;
import com.zfy.pojo.Roles;
import com.zfy.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={App.class})
public class OneToManyTest {

	@Autowired
	private UsersRepository usersRepository;
	
	/*
	 * 一对多关联关系的添加
	 */
	@Test
	public void testSave() {
		//创建一个用户；
		Users users=new Users();
		users.setName("小羊");
		users.setAge(28);
		//创建一个角色
		Roles roles=new Roles();
		roles.setRolename("普通用户");
		//关联
		//建立角色和用户的 关系
		roles.getUsers().add(users);
		users.setRoles(roles);
		//保存
		this.usersRepository.save(users);
	}
	/*
	 * 级联查询
	 */
	@Test
	public void testFindOne() {
		Users users = this.usersRepository.findOne(8);
		System.out.println(users);
		System.out.println(users.getRoles().getRolename());
	}
}
