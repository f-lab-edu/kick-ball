package com.kickball.domain.stadium.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "stadium")
@Entity
public class Stadium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "address", nullable = false, length = 100)
	private String address;

	@Column(name = "size", nullable = false, length = 50)
	private String size;

	@Column(name = "two_hour_rate")
	private int twoHourRate;

	@Lob
	@Column(name = "guidelines")
	private String guidelines;

	@Column(name = "parking")
	private boolean parking;

	@Column(name = "air_conditioning")
	private boolean airConditioning;

	@Column(name = "showers")
	private boolean showers;

	@Column(name = "ball_rental")
	private boolean ballRental;

	@Column(name = "vest_rental")
	private boolean vestRental;

	@Column(name = "shoes_rental")
	private boolean shoesRental;

	@Builder
	public Stadium(String name, String address, int width, int length, String guidelines, int twoHourRate,
		boolean parking, boolean airConditioning, boolean showers, boolean ballRental, boolean vestRental,
		boolean shoesRental) {
		this.name = name;
		this.address = address;
		this.size = String.valueOf(width + "x" + length);
		this.twoHourRate = twoHourRate;
		this.guidelines = guidelines;
		this.parking = parking;
		this.airConditioning = airConditioning;
		this.showers = showers;
		this.ballRental = ballRental;
		this.vestRental = vestRental;
		this.shoesRental = shoesRental;
	}

}
