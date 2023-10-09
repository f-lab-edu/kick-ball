package com.kickball.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kickball.reservation.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
