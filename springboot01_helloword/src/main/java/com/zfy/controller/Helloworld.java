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
	@ResponseBody
	public Map<String, Object> showHelloWorld(){
		Map<String, Object> map=new HashMap<>();
		map.put("msg", "helloworld");
		return map;
	}
}
