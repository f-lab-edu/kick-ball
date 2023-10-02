package com.kickball.domain.stadium.fixture;

import com.kickball.domain.stadium.domain.Stadium;

public class StadiumFixture {

	public static Stadium getStadiumFixture() {
		return Stadium.builder()
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
	}

}
