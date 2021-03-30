package com.demo;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {

	@Override
	public String name() {
		return "Cat";

	}

}
