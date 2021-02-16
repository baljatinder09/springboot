package com.room.reservation.service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.reservation.domainobject.Guest;
import com.room.reservation.domainobject.Reservation;
import com.room.reservation.domainobject.Room;
import com.room.reservation.domainobject.RoomReservation;
import com.room.reservation.feignclient.GuestServiceFeignClient;
import com.room.reservation.feignclient.ReservationServiceFeignClient;
import com.room.reservation.feignclient.RoomServiceFeignClient;

@Service
public class RoomGuestService {

	@Autowired
	private GuestServiceFeignClient guestFeignClient;
	
	@Autowired
	private RoomServiceFeignClient roomFeignClient;
	
	@Autowired
	private ReservationServiceFeignClient reservationFeignClient;
	
	
	private List<Reservation> fetchAllReservation()
	{
		return reservationFeignClient.fecthAllReservation();
	}
	
	private Reservation fetchReservationByDate(Date date)
	{
		return reservationFeignClient.fetchReservationByDate(date);
	}
	
	
	private List<Guest> fetchAllGuest()
	{
		return guestFeignClient.fecthAllGuest();
	}
	private Guest fetchGuestById(Long id)
	{
		return guestFeignClient.fetchGuestById(id);
	}
	
	private Room fetchRoomById(Long id)
	{
		return roomFeignClient.fetchRoom(id);
	}
	/**
	 * 
	 * @return
	 */
	public List<RoomReservation>  fecthAllReservedRoom()
	{
		List<Reservation> reservation=fetchAllReservation();
		List<RoomReservation> listReservedRoom=new ArrayList<RoomReservation>();
	   if(!reservation.isEmpty())
		{
			reservation.forEach(resObj -> {
				RoomReservation reservedRoom = new RoomReservation();
				reservedRoom.setId(resObj.getId());
				populateGuestDetail(reservedRoom, resObj.getGuestId());
				populateRoomDetail(reservedRoom, resObj.getRoomId());
				reservedRoom.setResDate(resObj.getResDate());
				listReservedRoom.add(reservedRoom);
			});

		}
	   return listReservedRoom;
	}
	private void populateGuestDetail(RoomReservation reservedRoom,Long guestId)
	{
		Guest guest=fetchGuestById(guestId);
		if(guest!=null)
		{
			reservedRoom.setGuestId(guest.getId());
			reservedRoom.setGuestName(guest.getFirstName() +" " + guest.getLastName());
			reservedRoom.setEmailAddress(guest.getEmail());
			reservedRoom.setCountry(guest.getCountry());
		}
	}	
	
	/**
	 * 
	 * @param reservedRoom
	 * @param roomId
	 */
	private void populateRoomDetail(RoomReservation reservedRoom,Long roomId)
	{
		Room room = fetchRoomById(roomId);
		if (room != null) {
			reservedRoom.setRoomId(room.getId());
			reservedRoom.setRoomName(room.getName());
			reservedRoom.setBedInfo(room.getBedInfo());
		}
	}
}
