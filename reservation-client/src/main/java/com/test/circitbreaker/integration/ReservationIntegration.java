package com.test.circitbreaker.integration;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.client.ReservationsRestClient;
import com.test.entity.Reservation;

@Component 
public class ReservationIntegration { 
 
 
    @Autowired 
    private ReservationsRestClient reservationsRestClient;
 
 
    public Collection<String> getReservationNamesFallback() {
        return Collections.emptyList();
    } 
 
 
    @HystrixCommand(fallbackMethod = "getReservationNamesFallback") 
    public Collection<String> getReservationNames() {
        return reservationsRestClient.getReservations()
                .stream() 
                .map(Reservation::getReservationName) 
                .collect(Collectors.toList()); 
    }   
 
 
} 