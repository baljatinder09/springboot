package com.room.reservation.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.room.reservation.domainobject.Guest;

@FeignClient(name="guestservices")
public interface GuestServiceFeignClient {
	
	@GetMapping("/guest")
	public List<Guest> fecthAllGuest();
	
	@GetMapping("/guest/{id}")
	public Guest fetchGuestById(@PathVariable("id") Long id);
	

}
