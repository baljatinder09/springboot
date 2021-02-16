package com.guest.controller;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guest.entity.Guest;
import com.guest.service.GuestService;

@RestController
@RequestMapping("/guest")
public class GuestController {
	
	private GuestService guestService;
	
	public GuestController(GuestService guestService)
	{
		this.guestService=guestService;
	}
	
	@GetMapping
	public Iterable<Guest> fetchAllGuest()
	{
		return guestService.fecthAllGuest();
	}
	
	@GetMapping("{id}")
	public Guest fetchById(@PathVariable("id") Long id)
	{
		return guestService.fecthById(id);
	}
	
	
}
