package com.reservation.repository;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import com.reservation.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>
{
	 public Reservation findByResDate(Date date);
}
