package com.kickball.domain.stadium.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

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
}
