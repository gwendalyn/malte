package org.rontai.p.aop;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public void saveTest() {
		System.out.println("saveTest()");
	}

	@Override
	public void saveTest(String str) {
		System.out.println("saveTest(str)");
	}

}
