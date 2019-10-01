package com.zfy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zfy.App;
import com.zfy.service.UserServiceImpl;


/**
 * SpringBoot测试类；
 * @RunWith 启动类
 * SpringJUnit4ClassRunner.class  让Junit和spring环境进行整合；
 * 
 * @SpringBootTest(classes={App.class})  1当前类为springboot测试类；
 * @SpringBootTest(classes={App.class})  2加载springboot的启动类，启动springboot；
 * 
 * 类似
 * Junit和spring整合 @contextconfiguration("classpath:applicationContext.xml")
 *@SpringBootTest 
 * 
 * 
 * @author DELL
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={App.class})
public class UserServiceTest {

	@Autowired
	private UserServiceImpl userServiceImpl;
	@Test
	public void testAddUser() {
		this.userServiceImpl.addUser();
	}
}
