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
public class StadiumRemoveService {

	private final StadiumRepository stadiumRepository;

	public void removeStadium(Long id) {
		Stadium foundStadium = stadiumRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Stadium Id가 존재하지 않습니다."));

		stadiumRepository.delete(foundStadium);
	}
}
