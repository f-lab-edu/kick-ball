package com.kickball.domain.reservation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.kickball.common.Fixture;
import com.kickball.domain.reservation.domain.Reservation;

@DataJpaTest
class ReservationRepositoryTest {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private TestEntityManager em;

	@Test
	public void 예약저장_조회_테스트() {
		Reservation reservation = Fixture.getFixture(em);

		Reservation savedReservation = reservationRepository.save(reservation);

		em.clear();

		Reservation foundReservation = reservationRepository.findById(savedReservation.getId()).orElse(null);

		assertNotNull(foundReservation);
		reservationEquals(reservation, foundReservation);
		reservationEquals(savedReservation, foundReservation);
	}

	@Test
	public void 예약_삭제_테스트() {
		Reservation reservation = Fixture.getFixture(em);

		Reservation savedReservation = reservationRepository.save(reservation);

		reservationRepository.delete(savedReservation);

		assertNull(reservationRepository.findById(savedReservation.getId()).orElse(null));

	}

	private void reservationEquals(Reservation expected, Reservation actual) {
		assertEquals(expected.getStartTime(), actual.getStartTime());
		assertEquals(expected.getReservationDate(), actual.getReservationDate());
		assertEquals(expected.getUseTime(), actual.getUseTime());
	}

}
