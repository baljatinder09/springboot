package com.room.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.room.entity.Room;

@Repository
public interface RoomRespository extends CrudRepository<Room, Long>
{

}
