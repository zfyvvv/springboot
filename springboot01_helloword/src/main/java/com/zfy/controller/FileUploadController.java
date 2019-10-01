package com.zfy.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//@Controller
@RestController //表示该类下方法的返回值会自动转成JSon格式，方法中不需要额外条件注解
public class FileUploadController {
	
	/*
	 * 处理文件上传
	 */
	@RequestMapping("fileUploadController")
	public Map<String, Object> fileUpload(MultipartFile filename) throws Exception{
		System.out.println(filename.getOriginalFilename());
		//保存的位置；
		filename.transferTo(new File("F:/"+filename.getOriginalFilename()));
		Map<String, Object> map=new HashMap<>();
		map.put("msg", "ok");
		return map;
	}
}
