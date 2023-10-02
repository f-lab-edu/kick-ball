package com.kickball.domain.stadium.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StadiumResponse {

	private Long id;

	public static StadiumResponse toDto(Long id) {
		return new StadiumResponse(id);
	}

}
