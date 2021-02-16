package com.reservation.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.reservation.entity.Reservation;
import com.reservation.repository.ReservationRepository;

@Service
public class ReservationService {

	private ReservationRepository repository;
	
	public ReservationService(ReservationRepository repository)
	{
		this.repository=repository;
	}
	
	public Iterable<Reservation>  fetchAllReservation()
 	{
		return repository.findAll();
	}
	
	public Reservation fetchReservatiobById(Long id)
	{
		 return repository.findById(id).get();
	}
	public Reservation fetchByResDate(Date date)
	{
		return repository.findByResDate(date);
	}
	
}
