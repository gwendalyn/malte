package org.malte.test;

import org.malte.base.Mbase;
import org.malte.m.one.Mone;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceExample {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:spring-context.xml");
		Mbase base = (Mbase) ctx.getBean("mbase");
		Mone one = (Mone) ctx.getBean("mone");
		base.greet();
		one.greet();
	}
}
