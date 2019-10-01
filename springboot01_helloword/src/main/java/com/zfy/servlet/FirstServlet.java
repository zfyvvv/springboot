package com.zfy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 整合方式一：
 * <servlet>
 * 	<servlet-name>FirstServlet</servlet-name>
 * 	<servlet-class>com.zfy.servlet.FirstServlet</servlet-class>
 * </servlet>
 * 
 * <servlet-mapping>
 * 	<servlet-name>FirstServlet</servlet-name>
 * 	<url-pattern>/first</url-pattern>
 * </servlet-mapping>
 * 
 * @author DELL
 *
 */

@WebServlet(name="/FirstServlet",urlPatterns="/first")
public class FirstServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("this is firstservlet of springboot!!! ");
		resp.getWriter().write("this is firstservlet of springboot!!!");
	}
}
