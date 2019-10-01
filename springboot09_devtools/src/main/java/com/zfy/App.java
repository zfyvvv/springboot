package com.zfy;

import javax.servlet.annotation.WebFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //在springboot启动时会自动扫描@webServlet,并将该类实例化；
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
