package com.frankmoley.lil.reservationservices;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationWebServices {
    private ReservationRepository repository;

    public ReservationWebServices(ReservationRepository repository){
        super();
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Reservation> getReservations(@RequestParam(name="date", required = false) Date date){
        if(null!=date){
            return this.repository.findAllByDate(date);
        }
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id") long id){
        return this.repository.findById(id).get();
    }
}
