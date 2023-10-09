package com.kickball.stadium.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kickball.stadium.domain.Stadium;
import com.kickball.stadium.repository.StadiumRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class StadiumAddService {

	private final StadiumRepository stadiumRepository;

	public void addStadium(Stadium stadium) {
		stadiumRepository.save(stadium);
	}

}
