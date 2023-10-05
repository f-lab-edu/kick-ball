package com.kickball.stadium.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.kickball.stadium.domain.Stadium;
import com.kickball.stadium.fixture.StadiumFixture;
import com.kickball.stadium.repository.StadiumRepository;

@SpringBootTest
class StadiumFindServiceTest {

	@Autowired
	private StadiumRepository stadiumRepository;

	@Autowired
	private StadiumFindService stadiumFindService;

	@Test
	@Transactional
	void 구장_리스트_읽기_테스트() {
		//given
		Pageable pageable = PageRequest.of(1, 10);
		for (int i = 0; i < 10; i++) {
			stadiumRepository.save(StadiumFixture.getStadium());
		}

		//when
		Page<Stadium> stadiums = stadiumFindService.findAllStadium(pageable);

		//then
		assertEquals(pageable.getPageSize(), stadiums.getTotalElements());
	}

	@Test
	void 구장_리스트_읽기_테스트_빈페이지_반환() {
		//given
		Pageable pageable = PageRequest.of(1, 10);

		//when
		Page<Stadium> stadiums = stadiumFindService.findAllStadium(pageable);

		//then
		assertEquals(0, stadiums.getTotalElements());
	}
}