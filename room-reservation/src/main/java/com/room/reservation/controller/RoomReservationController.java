package com.room.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.room.reservation.domainobject.Room;
import com.room.reservation.domainobject.RoomReservation;
import com.room.reservation.feignclient.RoomServiceFeignClient;
import com.room.reservation.service.RoomGuestService;

@RestController
@RequestMapping("/roomreservation")
public class RoomReservationController {

	private RoomGuestService roomGuestService;

	RoomReservationController(RoomGuestService roomGuestService) {
		this.roomGuestService = roomGuestService;
	}

	@Autowired
	private RoomServiceFeignClient client;

	@GetMapping
	public ResponseEntity<Room> fetchAllRoom() {
		List<Room> rooms = client.fetchAllRoom();
		return new ResponseEntity(rooms, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Room> fetchRoom(@PathVariable("id") Long id) {
		Room room = client.fetchRoom(id);
		if (room != null)
			return new ResponseEntity<Room>(room, HttpStatus.FOUND);
		else
			return new ResponseEntity("No room found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/reserved")
	public ResponseEntity<RoomReservation> fetchAllReservationDetial() {
		List<RoomReservation> roomReservationList = roomGuestService.fecthAllReservedRoom();
		if (!roomReservationList.isEmpty()) {
			return new ResponseEntity(roomReservationList, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
