package com.guest.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.guest.entity.Guest;
import com.guest.respository.GuestRepository;

@Service
public class GuestService {

	private GuestRepository repository;

	public GuestService(GuestRepository repository) {
		this.repository = repository;
	}

	public Iterable<Guest> fecthAllGuest() {
		return repository.findAll();
	}

	public Guest fecthById(Long id) {
		return repository.findById(id).get();
	}
   }
