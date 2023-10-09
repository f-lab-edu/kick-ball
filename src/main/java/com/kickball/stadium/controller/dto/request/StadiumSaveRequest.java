package com.kickball.stadium.controller.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.kickball.stadium.domain.Stadium;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class StadiumSaveRequest {

	@NotBlank(message = "구장 이름은 공백이면 안됩니다.")
	@Size(min = 1, max = 100, message = "구장 이름의 길이는 1이상, 100이하여야 합니다.")
	private String name;

	@NotBlank(message = "주소는 공백이면 안됩니다.")
	@Size(min = 1, max = 100, message = "주소의 길이는 1이상, 100이하여야 합니다.")
	private String address;

	@Min(value = 1, message = "가로 길이는 1 이상 이여야 합니다.")
	@Max(value = 150, message = "가로 길이는 150 이하 이여야 합니다.")
	private int width;

	@Min(value = 1, message = "세로 길이는 1 이상 이여야 합니다.")
	@Max(value = 150, message = "세로 길이는 150 이하 이여야 합니다.")
	private int length;

	@Min(value = 300_000, message = "2시간 가격은 300,000원 이하여야 합니다.")
	@Max(value = 10_000, message = "2시간 가격은 10,000원 이상이여야 합니다.")
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

}
