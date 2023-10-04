package com.kickball.stadium.utils;

import static org.junit.jupiter.api.Assertions.*;

import com.kickball.stadium.domain.Stadium;

public class StadiumTestUtils {

	public static void assertStadiumDataEquals(Stadium expected, Stadium actual) {
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getSize(), actual.getSize());
		assertEquals(expected.getAddress(), actual.getAddress());
		assertEquals(expected.getGuidelines(), actual.getGuidelines());
		assertEquals(expected.getTwoHourRate(), actual.getTwoHourRate());
		assertEquals(expected.isAirConditioning(), actual.isAirConditioning());
		assertEquals(expected.isShowers(), actual.isShowers());
		assertEquals(expected.isParking(), actual.isParking());
		assertEquals(expected.isBallRental(), actual.isBallRental());
		assertEquals(expected.isVestRental(), actual.isVestRental());
		assertEquals(expected.isShoesRental(), actual.isShoesRental());
	}
}
