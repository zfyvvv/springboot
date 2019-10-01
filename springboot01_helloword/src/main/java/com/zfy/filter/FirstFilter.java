package com.zfy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * springboot 整合filter
 * 
 * <filter>
 * 	<filter-name>FirstFilter</filter-name>
 * 	<filter-class>com.zfy.filter.FirstFilter</filter-class>
 * </filter>
 * <filter-mapping>
 * 	<filter-name>FirstFilter</filter-name>
 * 	<url-pattern>/first</url-pattern>	
 * </filter-mapping>
 * @author DELL
 *
 */
//@WebFilter(filterName="FirstFilter",urlPatterns={"*.do","*.jsp"})
@WebFilter(filterName="FirstFilter",urlPatterns="/first")
public class FirstFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("go to filter!");
		chain.doFilter(request, response);
		System.out.println("go away filter!");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
