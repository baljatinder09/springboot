package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.config.Config;
import com.example.demo.entity.President;
import com.example.demo.repository.PresidentRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

	
	
	private PresidentRepository presidentRepository;
	private Config config;
	
	@Autowired
	public RestController(PresidentRepository presidentRepository,Config config) {
		this.presidentRepository=presidentRepository;
		this.config=config;
	}
	
	@GetMapping("/presidents")
	public List<President> getList()
	{
		System.out.println("getUserId "+ config.getUserId());
		System.out.println("UserName "+ config.getUserName());
		List<President> pList=new ArrayList();
		Iterable<President> itr=presidentRepository.findAll();
		itr.forEach(pList::add);
		return pList;
	}
	
	@PostMapping("/presidents")
	public President addPresedent(@Valid @RequestBody President president)
	{
		return presidentRepository.save(president);
	}
	
	
}
