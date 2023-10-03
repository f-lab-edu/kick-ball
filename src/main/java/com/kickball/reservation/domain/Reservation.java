package com.kickball.reservation.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kickball.member.domain.Member;
import com.kickball.stadium.domain.Stadium;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "reservations")
@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stadium_id", nullable = false)
	private Stadium stadium;

	@Column(name = "reservation_date", nullable = false)
	private LocalDate reservationDate;

	@Column(name = "start_time", nullable = false)
	private LocalTime startTime;

	@Column(name = "use_time")
	private int useTime;

	@Builder
	public Reservation(Member member, Stadium stadium, LocalDate reservationDate, LocalTime startTime,
		int useTime) {
		this.member = member;
		this.stadium = stadium;
		this.reservationDate = reservationDate;
		this.startTime = startTime;
		this.useTime = useTime;
	}

}