package com.kickball.stadium.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.kickball.stadium.domain.Stadium;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StadiumSaveRequest {

	@NotBlank(message = "구장 이름은 공백이면 안됩니다.")
	@Length(min = 1, max = 100, message = "구장 이름의 길이는 1이상, 100이하여야 합니다.")
	private String name;

	@NotBlank(message = "주소는 공백이면 안됩니다.")
	@Length(min = 1, max = 100, message = "주소의 길이는 1이상, 100이하여야 합니다.")
	private String address;

	@Range(min = 1, max = 150, message = "가로 길이는 1이상, 150이하여야 합니다.")
	private int width;

	@Range(min = 1, max = 150, message = "세로 길이는 1이상, 150이하여야 합니다.")
	private int length;

	@Range(min = 10_000, max = 300_000, message = "2시간 가격은 10,000원 이상, 300,000원 이하여야 합니다.")
	private int twoHourRate;

	@NotBlank(message = "안내문은 공백이면 안됩니다.")
	private String guidelines;

	@NotNull(message = "주차 여부를 입력해야 합니다.")
	private Boolean parking;

	@NotNull(message = "에어컨 여부를 입력해야 합니다.")
	private Boolean airConditioning;

	@NotNull(message = "샤워실 여부를 입력해야 합니다.")
	private Boolean showers;

	@NotNull(message = "공대여 여부를 입력해야 합니다.")
	private Boolean ballRental;

	@NotNull(message = "조끼대여 여부를 입력해야 합니다.")
	private Boolean vestRental;

	@NotNull(message = "풋살화대여 여부를 입력해야 합니다. ")
	private Boolean shoesRental;

	public Stadium toEntity() {
		return Stadium.builder()
			.name(name)
			.address(address)
			.width(width)
			.length(length)
			.guidelines(guidelines)
			.twoHourRate(twoHourRate)
			.parking(parking)
			.airConditioning(airConditioning)
			.showers(showers)
			.ballRental(ballRental)
			.vestRental(vestRental)
			.shoesRental(shoesRental)
			.build();
	}

}
