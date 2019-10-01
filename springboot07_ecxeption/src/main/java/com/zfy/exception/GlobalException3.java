package com.zfy.exception;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class GlobalException3 implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv=new ModelAndView();
		//通过异常类型，跳转至指定页面；
		if(ex instanceof NullPointerException) {
			mv.setViewName("error1");
		}
		if(ex instanceof ArithmeticException) {
			mv.setViewName("error2");
		}
		//传递异常对象；
		mv.addObject("error", ex.toString());
		return mv;
	}
}
