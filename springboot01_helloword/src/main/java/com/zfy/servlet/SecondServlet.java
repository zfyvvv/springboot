package com.zfy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 整合方式二：
 * 
 * 
 * @author DELL
 *
 */

public class SecondServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("this is secondservlet of springboot!!! ");
		resp.getWriter().write("this is secondservlet of springboot!!!");
	}
}
