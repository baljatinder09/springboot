package com.room.reservation.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.room.reservation.domainobject.Room;

@FeignClient("roomservices")
public interface RoomServiceFeignClient {
	
	@GetMapping("/rooms")
	List<Room> fetchAllRoom();

	@GetMapping("/rooms/{id}")
	Room fetchRoom(@PathVariable("id")Long id);
}
