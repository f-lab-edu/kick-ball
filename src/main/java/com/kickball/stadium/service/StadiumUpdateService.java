package com.kickball.stadium.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kickball.stadium.domain.Stadium;
import com.kickball.stadium.repository.StadiumRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class StadiumUpdateService {

	private final StadiumRepository stadiumRepository;

	public Stadium updateStadium(Stadium updateData) {
		Stadium foundStadium = stadiumRepository.findById(updateData.getId())
			.orElseThrow(() -> new EntityNotFoundException("Stadium Id가 존재하지 않습니다."));

		foundStadium.update(updateData);

		return foundStadium;
	}
}
