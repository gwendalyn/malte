package org.rontai.p.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 * 
 */
public class App {
	static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		logger.debug("Hello World!");
		logger.error("hello error");
		logger.info("hello info!");
	}

}
