package com.zfy.exception;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class GlobalException2 {
	/**
	 * 该方法必须有返回值，返回值必须为SimpleMappingExceptionResolver
	 * @return
	 */
	@Bean
	public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver resolver=new SimpleMappingExceptionResolver();
		Properties mappings=new Properties();
		/*
		 * 参数一：异常类型的全名称；
		 * 参数二：出现异常需跳转的视图；
		 */
		mappings.put("java.lang.NullPointerException", "error1");
		mappings.put("java.lang.ArithmeticException", "error2");
		
		//设置异常和视图映射信息；
		resolver.setExceptionMappings(mappings);
		return resolver;
	}
}
