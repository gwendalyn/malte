package org.rontai.p.aop;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-aop.xml");
		ctx.refresh();
		
		TestService ts = (TestService) ctx.getBean("testServiceImpl");
		
		ts.saveTest();
		
		ts.saveTest("cc");
	}

}
