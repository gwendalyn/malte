package org.rontai.p.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

	static Logger logger = LoggerFactory.getLogger(LogTest.class);

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++){
			logger.info("from log package");
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				
			}
		}
	}

}
