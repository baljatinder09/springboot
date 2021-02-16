package com.pattern.qualifire;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
//@Component
public class Pet implements Animal {

	@Override
	public String qualities() {
		// TODO Auto-generated method stub
		return "Cat Meuow";
	}

}
