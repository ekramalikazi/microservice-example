package com.test.entity;

public class Reservation {

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