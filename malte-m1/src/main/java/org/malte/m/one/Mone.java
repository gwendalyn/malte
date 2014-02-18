package org.malte.m.one;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Mone {

	@PostConstruct
	public void init(){
		System.out.println("Mone post-construct");
	}
	
	public void greet(){
		System.out.println("Greeting from malte-m1");
	}
}
