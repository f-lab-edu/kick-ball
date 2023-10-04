package com.kickball.stadium.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kickball.stadium.domain.Stadium;
import com.kickball.stadium.fixture.StadiumFixture;
import com.kickball.stadium.repository.StadiumRepository;
import com.kickball.stadium.utils.StadiumTestUtils;

@ExtendWith(MockitoExtension.class)
class StadiumSaveServiceMockTest {

	@Mock
	private StadiumRepository stadiumRepository;

	@InjectMocks
	private StadiumSaveService stadiumSaveService;

	@Test
	void 구장_생성_테스트() {
		//given
		Stadium stadium = StadiumFixture.getStadium();
		given(stadiumRepository.save(any(Stadium.class))).willReturn(stadium);

		//when
		Stadium savedStadium = assertDoesNotThrow(() -> stadiumSaveService.saveStadium(stadium));

		//then
		StadiumTestUtils.assertStadiumDataEquals(stadium, savedStadium);
	}

}