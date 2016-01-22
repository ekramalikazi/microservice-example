package com.test.circitbreaker.integration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping ("/reservations") 
class ReservationNamesRestController { 
 
 
    @RequestMapping("/names") 
    Collection<String> rs() {
        return this.reservationIntegration.getReservationNames();
    } 
 
 
    @Autowired 
    private ReservationIntegration reservationIntegration;
 
 
} 