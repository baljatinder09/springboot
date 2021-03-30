package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDemo {
	
	@Qualifier("dog")
	@Autowired
	private Animal animal1;
	
	@Qualifier("cat")
	@Autowired
	private Animal animal12;
	
	@GetMapping("/show")
	public String show()
	{
		return animal1.name();
	}
	@GetMapping("/show2")
	public String show2()
	{
		return animal12.name();
	}
	
	

}
