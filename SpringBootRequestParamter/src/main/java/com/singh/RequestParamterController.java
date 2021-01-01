package com.singh;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("requestParameter")
public class RequestParamterController {
	
	@GetMapping("/{message}")
	public String pathVariable(@PathVariable(name="message", required=false) String message)
	{
		return "PathVariable Message : "+ message;
	}
	
	@GetMapping
	public String requestParameter(@RequestParam(name="message", defaultValue="defaultMessage", required=false) String message)
	{
	   return "RequestParam Message :"+ message;	
	}

}
