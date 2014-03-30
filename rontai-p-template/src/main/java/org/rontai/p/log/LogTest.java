package org.rontai.p.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

	static Logger logger = LoggerFactory.getLogger(LogTest.class);

	public static void main(String[] args) {
		try {
			doSomething();
		} catch (Exception e) {
			logger.trace("cc", e);
		}
		logger.debug("111");
		logger.info("info");
		logger.warn("warn");
	}

	private static void doSomething() {
		throw new RuntimeException("abc");
	}

}
