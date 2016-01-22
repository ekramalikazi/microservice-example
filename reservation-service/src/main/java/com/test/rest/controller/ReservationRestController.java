package com.test.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Reservation;
import com.test.jpa.ReservationRepository;

@RestController
public class ReservationRestController {


    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping("/reservations")
    public Collection<Reservation> reservations() {
        return this.reservationRepository.findAll();
    }


}