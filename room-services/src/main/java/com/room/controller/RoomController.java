package com.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.room.entity.Room;
import com.room.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping
	public Iterable<Room> getAllRooom() {
		return roomService.getRooms();
	}

	@GetMapping("/{id}")
	public Room room(@PathVariable("id") Long id) {
		return roomService.findById(id);
	}
}
