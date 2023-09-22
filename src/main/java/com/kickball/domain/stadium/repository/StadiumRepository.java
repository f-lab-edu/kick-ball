package com.kickball.domain.stadium.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kickball.domain.stadium.domain.Stadium;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
