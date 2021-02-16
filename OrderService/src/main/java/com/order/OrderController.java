package com.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderAPI")
public class OrderController {
	
	
	@Autowired
	private Environment env;
	
	@GetMapping("/placedOrder/{orderId}")
	public String placeOrder(@PathVariable int orderId)
	{
		String port= (String)env.getProperty("local.server.port");
		return "Order placed :: "+ orderId +" Port :: " + port;
	}

}
