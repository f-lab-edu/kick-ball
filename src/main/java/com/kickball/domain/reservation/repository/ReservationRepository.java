package com.kickball.domain.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kickball.domain.reservation.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
