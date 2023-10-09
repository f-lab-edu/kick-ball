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
public class StadiumModifyService {

	private final StadiumRepository stadiumRepository;

	public Stadium modifyStadium(Long id, Stadium updateData) {
		Stadium foundStadium = stadiumRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("구장이 존재하지 않습니다."));

		foundStadium.update(updateData);

		return foundStadium;
	}
}
