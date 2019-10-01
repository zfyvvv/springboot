package com.zfy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * springboot helloword
 * @author DELL
 *
 */
@Controller
public class Helloworld {
	
	@RequestMapping("/hello")
	public String showHelloWorld(){
		System.out.println("hello222....");
		return "index";
	}
}
