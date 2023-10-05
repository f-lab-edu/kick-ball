package com.kickball.stadium.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kickball.stadium.domain.Stadium;
import com.kickball.stadium.repository.StadiumRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StadiumFindService {

	private final StadiumRepository stadiumRepository;

	public Page<Stadium> findAllStadium(Pageable pageable) {
		return stadiumRepository.findAll(pageable);
	}

	public Stadium findStadiumById(Long id) {
		return stadiumRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Stadium Id가 존재하지 않습니다."));
	}

}
