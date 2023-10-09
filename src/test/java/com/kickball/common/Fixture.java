package com.kickball.common;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.kickball.member.domain.Member;
import com.kickball.reservation.domain.Reservation;
import com.kickball.stadium.domain.Stadium;

public class Fixture {

	public static Reservation getReservationFixture(TestEntityManager em) {
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
