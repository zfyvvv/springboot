package com.zfy.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * <listener>
 * 	<listener-class>com.zfy.listener.FirstListener</listener-class>
 * </listener>
 * @author DELL
 *
 */
@WebListener
public class FirstListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("firstListener");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
