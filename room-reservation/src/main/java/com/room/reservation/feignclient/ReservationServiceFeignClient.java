package com.room.reservation.feignclient;

import java.sql.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.room.reservation.domainobject.Reservation;

@FeignClient(name="reservationservices")
public interface ReservationServiceFeignClient {
	
	@GetMapping("/reservation")
	public List<Reservation> fecthAllReservation();
	
	@GetMapping("/reservation/{id}")
	public Reservation fetchReservationById(@PathVariable("id") Long id);
	
	@GetMapping("/reservation/{date}")
	public Reservation fetchReservationByDate(@PathVariable("date") Date date);
}
