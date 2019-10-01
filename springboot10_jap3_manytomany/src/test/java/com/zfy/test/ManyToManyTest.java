package com.zfy.test;


import java.util.Set;

import javax.management.relation.Role;
import javax.management.relation.RoleList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zfy.App;
import com.zfy.dao.RolesRepository;
import com.zfy.pojo.Menus;
import com.zfy.pojo.Roles;
import com.zfy.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={App.class})
public class ManyToManyTest {

	@Autowired
	private RolesRepository rolesRepository;
	
	/*
	 * 多对多关联关系的添加
	 */
	@Test
	public void testSave() {
		//创建角色对象；
		Roles role=new Roles();
		role.setRolename("项目经理");
		//创建菜单对象
		Menus menus=new Menus();
		menus.setMenusname("xxx管理系统");
		menus.setFatherid(0);
		
		Menus menus2=new Menus();
		menus2.setMenusname("项目管理");
		menus2.setFatherid(1);
		
		//关联
		role.getMenus().add(menus);
		role.getMenus().add(menus2);
		menus.getRoles().add(role);
		menus2.getRoles().add(role);
		
		//保存
		this.rolesRepository.save(role);
	}
	
	/*
	 * 级联查询
	 */
	@Test
	public void testFind() {
		Roles roles=this.rolesRepository.findOne(1);
		System.out.println(roles.getRolename());
		Set<Menus> menus=roles.getMenus();
		for(Menus m:menus) {
			System.out.println(m);
		}
	}
}
