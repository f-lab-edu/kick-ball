package com.kickball.stadium.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kickball.stadium.domain.Stadium;
import com.kickball.stadium.controller.dto.response.StadiumResponse;
import com.kickball.stadium.fixture.StadiumFixture;
import com.kickball.stadium.repository.StadiumRepository;

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

		//when & then
		Stadium savedStadium = assertDoesNotThrow(() -> stadiumSaveService.saveStadium(stadium));
		assertEquals(stadium.getName(), savedStadium.getName());
		assertEquals(stadium.getSize(), savedStadium.getSize());
		assertEquals(stadium.getAddress(), savedStadium.getAddress());
		assertEquals(stadium.getGuidelines(), savedStadium.getGuidelines());
		assertEquals(stadium.getTwoHourRate(), savedStadium.getTwoHourRate());
		assertEquals(stadium.isAirConditioning(), (savedStadium.isAirConditioning()));
		assertEquals(stadium.isShowers(), (savedStadium.isShowers()));
		assertEquals(stadium.isParking(), (savedStadium.isParking()));
		assertEquals(stadium.isBallRental(), (savedStadium.isBallRental()));
		assertEquals(stadium.isVestRental(), (savedStadium.isVestRental()));
		assertEquals(stadium.isShoesRental(), (savedStadium.isShoesRental()));
	}

}