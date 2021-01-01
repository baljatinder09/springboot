package com.singh;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hellospringboot")
@RestController
public class HelloSpringBootController {

	@GetMapping
	public String message() {
		return "Hello Spring Boot";
	}
}
