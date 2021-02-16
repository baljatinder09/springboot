package com.pattern.qualifire;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

	@Override
	public String qualities() {
		return "Dog barking";

	}

}
