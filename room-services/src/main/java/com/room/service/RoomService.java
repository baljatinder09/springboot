package com.room.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.entity.Room;
import com.room.respository.RoomRespository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRespository roomRespository;

	//public RoomService(RoomRespository roomRespository) {
	//	this.roomRespository = roomRespository;
	//}

	/**
	 * 
	 * @return
	 */
	public Iterable<Room> getRooms() {
		return this.roomRespository.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Room findById(Long id) {
		return this.roomRespository.findById(id).get();
	}

}
