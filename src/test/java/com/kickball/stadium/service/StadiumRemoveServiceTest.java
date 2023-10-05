package com.kickball.stadium.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kickball.stadium.domain.Stadium;
import com.kickball.stadium.fixture.StadiumFixture;
import com.kickball.stadium.repository.StadiumRepository;

@SpringBootTest
class StadiumRemoveServiceTest {

	@Autowired
	private StadiumRepository stadiumRepository;

	@Autowired
	private StadiumRemoveService stadiumRemoveService;

	@Test
	public void 구장_삭제_테스트() {
		//given
		Stadium savedStadium = stadiumRepository.saveAndFlush(StadiumFixture.getStadium());
		Long id = savedStadium.getId();
		long beforeDeleteCount = stadiumRepository.count();

		//when
		stadiumRemoveService.removeStadium(id);
		long afterDeleteCount = stadiumRepository.count();

		//then
		assertEquals(beforeDeleteCount - 1, afterDeleteCount);
	}

	@Test
	public void 구장_삭제_테스트_존재하지_않는_Id() {
		//given
		Stadium savedStadium = stadiumRepository.saveAndFlush(StadiumFixture.getStadium());
		Long id = 0L;

		//when & then
		assertThrows(EntityNotFoundException.class, () -> stadiumRemoveService.removeStadium(id));
	}
}