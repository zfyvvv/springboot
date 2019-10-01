package com.zfy.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zfy.pojo.User;

@Controller
public class UserController {
	@RequestMapping("/showUser")
	public String showUser(Model model) {
		List<User> list=new ArrayList<>();
		list.add(new User(1,"张三",25));
		list.add(new User(2,"李四",26));
		list.add(new User(3,"王五",27));
		model.addAttribute("userList", list);
		return "userList";
	}
}
