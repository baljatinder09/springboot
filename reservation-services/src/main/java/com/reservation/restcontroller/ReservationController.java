package com.reservation.restcontroller;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.entity.Reservation;
import com.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	private ReservationService reservationService;
	
	public ReservationController(ReservationService reservationService)
	{
		this.reservationService=reservationService;
	}
	
	@GetMapping("/all")
	public Iterable<Reservation> fetchAllReservation()
	{
		return reservationService.fetchAllReservation();
	}
	
	@GetMapping("{id}")
	public Reservation fetchById(@PathVariable("id") Long id)
	{
		return reservationService.fetchReservatiobById(id);
	}
	@GetMapping
    public Reservation fetchByDate(@RequestParam(name="resDate", required=false) Date date)
    {
		return reservationService.fetchByResDate(date);	
    }

}
