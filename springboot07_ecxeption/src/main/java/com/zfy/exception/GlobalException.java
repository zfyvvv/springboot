package com.zfy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException {
	
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
	/*
	 * java.lang.ArithmeticException异常处理方法；
	 * 
	 */
	@ExceptionHandler(value= {java.lang.ArithmeticException.class})
	public ModelAndView ArithmeticExceptionHandler(Exception e) {
		ModelAndView mov=new ModelAndView();
		mov.addObject("error", e.toString());
		mov.setViewName("error2");
		return mov;
	}
	
	
}
