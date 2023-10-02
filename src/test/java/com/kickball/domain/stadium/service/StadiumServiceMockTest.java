package com.kickball.domain.stadium.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kickball.domain.stadium.domain.Stadium;
import com.kickball.domain.stadium.dto.request.StadiumSaveRequest;
import com.kickball.domain.stadium.dto.response.StadiumResponse;
import com.kickball.domain.stadium.fixture.StadiumFixture;
import com.kickball.domain.stadium.repository.StadiumRepository;

@ExtendWith(MockitoExtension.class)
class StadiumServiceMockTest {

	@Mock
	private StadiumRepository stadiumRepository;

	@InjectMocks
	private StadiumService stadiumService;

	@Test
	void 구장_생성_테스트() {
		//given
		StadiumSaveRequest request = StadiumFixture.getStadiumSaveRequest();
		Stadium stadium = request.toEntity();
		given(stadiumRepository.save(any(Stadium.class))).willReturn(stadium);

		//when & then
		StadiumResponse response = assertDoesNotThrow(() -> stadiumService.saveStadium(request));
	}

}