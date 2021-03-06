package com.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {


    @Id
    @GeneratedValue
    private Long id;


    private String reservationName;


    public Reservation() { // why JPA why???
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationName='" + reservationName + '\'' +
                '}';
    }


    public Long getId() {
        return id;
    }


    public String getReservationName() {
        return reservationName;
    }


    public Reservation(String reservationName) {
        this.reservationName = reservationName;
    }
}