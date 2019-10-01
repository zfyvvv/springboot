package com.zfy.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zfy.pojo.User;

@Controller
public class UserController {
	/*
	 * 登录页面
	 * 异常方式解决一：可以在跳转页面的方法中注入一个User对象；
	 * 注意，由于该对象会被springMVC放入model中，
	 * key的名称会使用该对象的驼峰式的命名规则作为key，
	 * 参数的变量名要和对象的 名称相同，将首字母小写；
	 * 
	 * 如果想为传递的对象更改名称，可以使用@ModelAttribute("aa")表示当前传递对象的key为aa；
	 * public String addUser(@ModelAttribute("aa") User user) {
	 * 那么在页面中获取对象的key，也是“aa”;
	 * 同样后续的save()方法中，也需要进行注解；
	 * 
	 * 
	 */
	@RequestMapping("/addUser")
	public String addUser(User user) {
		return "addUser";
	}
	/*
	 * 用户注册完成页面
	 * @Valid 开启对User对象的数据校验；
	 * BindingResult 封装了校验的结果，会以model的形式传递给页面；
	 * 		为true，则数据检验失败，跳转至登录页面；
	 * 		为false，则数据检验成功，执行下一步；
	 */
	@RequestMapping("/save")
	public String save(@Valid User user,BindingResult result) {
		if(result.hasErrors()) {
			return "addUser";
		}
		System.out.println(user.toString());
		return "ok";
	}
}
