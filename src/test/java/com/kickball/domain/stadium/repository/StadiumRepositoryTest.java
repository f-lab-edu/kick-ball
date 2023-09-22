package com.kickball.domain.stadium.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.kickball.domain.stadium.domain.Stadium;

@DataJpaTest
class StadiumRepositoryTest {

	@Autowired
	private StadiumRepository stadiumRepository;

	@Autowired
	private TestEntityManager em;

	@Test
	public void 구장저장_조회_테스트() {

		Stadium stadium = getFixture();

		Stadium savedStadium = stadiumRepository.save(stadium);

		em.clear();

		Stadium foundStadium = stadiumRepository.findById(savedStadium.getId()).orElse(null);

		assertNotNull(foundStadium);
		stadiumEquals(stadium, savedStadium);
		stadiumEquals(savedStadium, foundStadium);
	}

	@Test
	public void 구장_삭제_테스트() {
		Stadium stadium = getFixture();

		Stadium savedStadium = stadiumRepository.save(stadium);

		stadiumRepository.delete(savedStadium);

		assertNull(stadiumRepository.findById(savedStadium.getId()).orElse(null));
	}

	private static void stadiumEquals(Stadium expected, Stadium actual) {
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getSize(), actual.getSize());
		assertEquals(expected.getAddress(), actual.getAddress());
		assertEquals(expected.getGuidelines(), actual.getGuidelines());
		assertEquals(expected.isAirConditioning(), (actual.isAirConditioning()));
		assertEquals(expected.isShowers(), (actual.isShowers()));
		assertEquals(expected.isParking(), (actual.isParking()));
		assertEquals(expected.isBallRental(), (actual.isBallRental()));
		assertEquals(expected.isVestRental(), (actual.isVestRental()));
		assertEquals(expected.isShoesRental(), (actual.isShoesRental()));
	}

	private static Stadium getFixture() {
		return Stadium.builder()
			.name("구장 1")
			.address("인천시 부평구 갈산동")
			.width(30)
			.length(15)
			.guidelines("[안내문]\n" + "해당 구장은 5vs5 입니다.\n" + "별도의 쓰레기통이 없으니 발생하는 쓰레기는 가져가주시길 바랍니다.")
			.parking(true)
			.airConditioning(true)
			.showers(false)
			.ballRental(true)
			.vestRental(true)
			.shoesRental(false)
			.build();
	}

}
