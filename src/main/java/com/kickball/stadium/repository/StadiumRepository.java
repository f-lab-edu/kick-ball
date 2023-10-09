package com.kickball.stadium.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kickball.stadium.domain.Stadium;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
