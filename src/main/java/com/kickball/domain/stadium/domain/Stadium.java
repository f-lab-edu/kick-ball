package com.kickball.domain.stadium.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stadium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String address;
	private String size;
	private String guidelines;

	private boolean parking;
	private boolean airConditioning;
	private boolean showers;
	private boolean ballRental;
	private boolean vestRental;
	private boolean shoesRental;
}
