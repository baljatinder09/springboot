package com.demo;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Dog";

	}

}
