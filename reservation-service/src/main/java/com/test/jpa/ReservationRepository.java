package com.test.jpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Collection<Reservation> findByReservationName(String rn);
}