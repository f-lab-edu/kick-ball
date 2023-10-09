package com.kickball.stadium.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kickball.stadium.domain.Stadium;
import com.kickball.stadium.fixture.StadiumFixture;
import com.kickball.stadium.repository.StadiumRepository;
import com.kickball.stadium.utils.StadiumTestUtils;

@SpringBootTest
class StadiumModifyServiceTest {

	@Autowired
	private StadiumRepository stadiumRepository;

	@Autowired
	private StadiumModifyService stadiumModifyService;

	@Test
	void 구장_수정_테스트() {
		//given
		Stadium savedStadium = stadiumRepository.save(StadiumFixture.getStadium());
		Long id = savedStadium.getId();
		Stadium updateData = StadiumFixture.getUpdatedStadium();

		//when
		Stadium stadium = stadiumModifyService.modifyStadium(id, updateData);

		//then
		StadiumTestUtils.assertStadiumDataEquals(updateData, stadium);
	}

	@Test
	void 구장_수정_테스트_존재하지_않는_Id() {
		//given
		Long id = 0L;
		Stadium updateData = StadiumFixture.getUpdatedStadium();

		//when & then
		assertThrows(EntityNotFoundException.class, () -> stadiumModifyService.modifyStadium(id, updateData));
	}

}