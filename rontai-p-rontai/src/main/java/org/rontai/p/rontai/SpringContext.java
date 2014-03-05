package org.rontai.p.rontai;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext implements ServletContextListener{
	
	public static ApplicationContext context;

	public void contextDestroyed(ServletContextEvent arg0) {
		
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("system initialized!");
		context = new ClassPathXmlApplicationContext(
				"classpath:spring-context.xml");
		
	}

	
	
}
