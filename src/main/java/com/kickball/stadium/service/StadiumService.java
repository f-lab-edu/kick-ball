package com.kickball.stadium.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kickball.stadium.domain.Stadium;
import com.kickball.stadium.dto.request.StadiumSaveRequest;
import com.kickball.stadium.dto.response.StadiumResponse;
import com.kickball.stadium.repository.StadiumRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class StadiumService {

	private final StadiumRepository stadiumRepository;

	public StadiumResponse saveStadium(StadiumSaveRequest request) {
		Stadium stadium = request.toEntity();

		Stadium savedStadium = stadiumRepository.save(stadium);

		return StadiumResponse.toDto(savedStadium.getId());
	}

}
