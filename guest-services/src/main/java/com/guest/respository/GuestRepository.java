package com.guest.respository;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import com.guest.entity.Guest;


public interface GuestRepository extends CrudRepository<Guest, Long>
{
   
}
