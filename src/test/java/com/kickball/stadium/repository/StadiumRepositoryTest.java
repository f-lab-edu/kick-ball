package com.kickball.stadium.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.kickball.stadium.domain.Stadium;
import com.kickball.stadium.fixture.StadiumFixture;

@DataJpaTest
class StadiumRepositoryTest {

	@Autowired
	private StadiumRepository stadiumRepository;

	@Autowired
	private TestEntityManager em;

	@Test
	public void 구장저장_조회_테스트() {

		Stadium stadium = StadiumFixture.getStadium();

		Stadium savedStadium = stadiumRepository.save(stadium);

		em.clear();

		Stadium foundStadium = stadiumRepository.findById(savedStadium.getId()).orElse(null);

		assertNotNull(foundStadium);
		stadiumEquals(stadium, savedStadium);
		stadiumEquals(savedStadium, foundStadium);
	}

	@Test
	public void 구장_삭제_테스트() {
		Stadium stadium = StadiumFixture.getStadium();

		Stadium savedStadium = stadiumRepository.save(stadium);

		stadiumRepository.delete(savedStadium);

		assertNull(stadiumRepository.findById(savedStadium.getId()).orElse(null));
	}

	private static void stadiumEquals(Stadium expected, Stadium actual) {
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getSize(), actual.getSize());
		assertEquals(expected.getAddress(), actual.getAddress());
		assertEquals(expected.getGuidelines(), actual.getGuidelines());
		assertEquals(expected.getTwoHourRate(), actual.getTwoHourRate());
		assertEquals(expected.isAirConditioning(), (actual.isAirConditioning()));
		assertEquals(expected.isShowers(), (actual.isShowers()));
		assertEquals(expected.isParking(), (actual.isParking()));
		assertEquals(expected.isBallRental(), (actual.isBallRental()));
		assertEquals(expected.isVestRental(), (actual.isVestRental()));
		assertEquals(expected.isShoesRental(), (actual.isShoesRental()));
	}

}
