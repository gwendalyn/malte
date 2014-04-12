package org.rontai.p.aop;

import org.aspectj.lang.JoinPoint;

public class MyAdvice {

	public void simpleBeforeAdvice(JoinPoint joinPoint) {
		
		System.out.println(joinPoint.getSignature().getDeclaringTypeName()
				+ " " + joinPoint.getSignature().getName());
	}

}
