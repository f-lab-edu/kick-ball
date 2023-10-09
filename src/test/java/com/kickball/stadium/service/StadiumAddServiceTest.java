package com.kickball.stadium.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kickball.stadium.domain.Stadium;
import com.kickball.stadium.fixture.StadiumFixture;
import com.kickball.stadium.repository.StadiumRepository;

@SpringBootTest
class StadiumAddServiceTest {

	@Autowired
	private StadiumRepository stadiumRepository;

	@Autowired
	private StadiumAddService stadiumAddService;

	@Test
	void 구장_생성_테스트() {
		//given
		Stadium stadium = StadiumFixture.getStadium();

		//when & then
		assertDoesNotThrow(() -> stadiumAddService.addStadium(stadium));
	}

}