package com.zfy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zfy.pojo.Users;
import com.zfy.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UserService usersService;

	/*
	 * 页面跳转；
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	/*
	 * 添加用户
	 */
	@RequestMapping("/addUser")
	public String addUser(Users users) {
		this.usersService.addUser(users);
		return "ok";
	}
	/*
	 * 显示所有用户
	 */
	@RequestMapping("/showUserAll")
	public String showUserAll(Model model) {
		model.addAttribute("usersList", this.usersService.findUserAll());
		return "showAll";
	}
	/*
	 * 删除指定ID的用户
	 */
	@RequestMapping("/delUser")
	public String delUser(Integer index) {
		this.usersService.deleteUser(index);
		return "ok";
	}
}
