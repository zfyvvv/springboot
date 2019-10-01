package com.zfy;

import javax.servlet.annotation.WebFilter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.zfy.mapper") //用于扫描mybatis的mapper接口
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
