package com.test.client;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.entity.Reservation;

@FeignClient("reservation-service") 
public interface ReservationsRestClient { 
 
    @RequestMapping(value = "/reservations", method = RequestMethod.GET) 
    Collection<Reservation> getReservations();
} 