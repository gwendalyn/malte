package org.rontai.s.base;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContext implements ServletContextListener {
	
	static Logger logger = LoggerFactory.getLogger(SpringContext.class);

	private static ApplicationContext context;

	public void contextDestroyed(ServletContextEvent event) {

	}

	public void contextInitialized(ServletContextEvent event) {
		// context = new ClassPathXmlApplicationContext(
		// "classpath*:spring-context.xml");
		context = WebApplicationContextUtils.getWebApplicationContext(event
				.getServletContext());
		if(context != null){
			logger.debug("Spring Context initialized successfully!");
		}else {
			logger.error("Spring Context initialization failed!");
		}
	}

	public static ApplicationContext getApplicationContext() {
		return context;
	}
}
