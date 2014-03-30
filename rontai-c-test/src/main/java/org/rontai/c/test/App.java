package org.rontai.c.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 * 
 */
public class App {
	
	static Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		try {
			doSomething();
		} catch (Exception e) {
			logger.trace("cc", e);
		}
	}

	private static void doSomething() {
		throw new RuntimeException("abc");
	}
}
