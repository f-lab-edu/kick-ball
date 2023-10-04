package com.kickball.stadium.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
class StadiumUpdateServiceMockTest {

	@Mock
	private StadiumRepository stadiumRepository;

	@InjectMocks
	private StadiumUpdateService stadiumUpdateService;

	@Test
	void 구장_수정_테스트() {
		//given
		Stadium updateData = StadiumFixture.getUpdatedStadium();
		Stadium foundStadium = StadiumFixture.getStadium();
		given(stadiumRepository.findById(any())).willReturn(Optional.of(foundStadium));

		//when
		Stadium result = stadiumUpdateService.updateStadium(updateData);

		//then
		StadiumTestUtils.assertStadiumDataEquals(updateData, foundStadium);
	}

	@Test
	void 구장_수정_테스트_Id가_존재하지_않을시() {
		//given
		Stadium updateData = StadiumFixture.getUpdatedStadium();
		Stadium foundStadium = StadiumFixture.getStadium();
		given(stadiumRepository.findById(any())).willReturn(Optional.empty());

		//when & then
		EntityNotFoundException e = assertThrows(EntityNotFoundException.class,
			() -> stadiumUpdateService.updateStadium(updateData));

		//then
		assertEquals("Stadium Id가 존재하지 않습니다.", e.getMessage());
	}

}