package com.order;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bookorderAPI")
@RibbonClient(name="orderservice")
public class BookOrderController {

	@Autowired
	private RestTemplate restTemp;
	
	@GetMapping
	public String BookOrder(){
		
		int Random = (int)(Math.random()*100);
		Map<String, Integer> vars = new HashMap<>();
		vars.put("orderNo", Random);
			String response=restTemp.getForObject("http://orderservice/orderAPI/placedOrder/{orderNo}", String.class,vars);
	return response;
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
}
