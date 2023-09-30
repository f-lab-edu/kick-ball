package com.kickball.domain.reservation.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.kickball.domain.member.domain.Member;
import com.kickball.domain.reservation.domain.Reservation;
import com.kickball.domain.stadium.domain.Stadium;

@DataJpaTest
class ReservationRepositoryTest {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private TestEntityManager em;

	@Test
	public void 예약저장_조회_테스트() {
		Reservation reservation = getFixture(em);

		Reservation savedReservation = reservationRepository.save(reservation);

		em.clear();

		Reservation foundReservation = reservationRepository.findById(savedReservation.getId()).orElse(null);

		assertNotNull(foundReservation);
		reservationEquals(reservation, foundReservation);
		reservationEquals(savedReservation, foundReservation);
	}

	@Test
	public void 예약_삭제_테스트() {
		Reservation reservation = getFixture(em);

		Reservation savedReservation = reservationRepository.save(reservation);

		reservationRepository.delete(savedReservation);

		assertNull(reservationRepository.findById(savedReservation.getId()).orElse(null));

	}

	private void reservationEquals(Reservation expected, Reservation actual) {
		assertEquals(expected.getStartTime(), actual.getStartTime());
		assertEquals(expected.getReservationDate(), actual.getReservationDate());
		assertEquals(expected.getUseTime(), actual.getUseTime());
	}

	private Reservation getFixture(TestEntityManager em) {
		Member member = new Member("base6666@naver.com", "12345", "kakao");
		Member savedMember = em.persist(member);

		Stadium stadium = Stadium.builder()
			.name("구장 1")
			.address("인천시 부평구 갈산동")
			.width(30)
			.length(15)
			.guidelines("[안내문]\n" + "해당 구장은 5vs5 입니다.\n" + "별도의 쓰레기통이 없으니 발생하는 쓰레기는 가져가주시길 바랍니다.")
			.twoHourRate(80000)
			.parking(true)
			.airConditioning(true)
			.showers(false)
			.ballRental(true)
			.vestRental(true)
			.shoesRental(false)
			.build();
		Stadium savedStadium = em.persist(stadium);

		em.flush();

		return Reservation.builder()
			.member(savedMember)
			.stadium(savedStadium)
			.reservationDate(LocalDate.now())
			.startTime(LocalTime.of(5, 0, 0))
			.useTime(2)
			.build();
	}

}
