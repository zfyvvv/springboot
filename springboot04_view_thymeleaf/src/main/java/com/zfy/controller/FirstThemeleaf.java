package com.zfy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class FirstThemeleaf {
	
	@RequestMapping("/showMsg")
	public String showMsg(Model model){
		model.addAttribute("msg", "the first themeleaf!");
		return "msg";
	}
}
