package com.zfy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	
	@RequestMapping("/hello")
	public String hello() {
		String str=null;
		str.length();
		return "index";
	}
	
	@RequestMapping("/hello1")
	public String hello1() {
		String str=null;
		str.length();
		return "index";
	}
	
	@RequestMapping("/hello2")
	public String hello2() {
		int i=10/0;
		return "index";
	}
	/*
	 * java.lang.NullPointerException异常处理方法
	 * 该方法需要返回一个ModelAndView，目的是可以封装异常信息以及视图控制；
	 * Exception e：将产生的异常对象注入到方法中去，方便后续处理；
	 */
	@ExceptionHandler(value= {java.lang.NullPointerException.class})
	public ModelAndView NullPointerExceptionHandler(Exception e) {
		ModelAndView mov=new ModelAndView();
		mov.addObject("error", e.toString());
		mov.setViewName("error1");
		return mov;
	}
	
}
