package com.kickball.member.fixture;

import com.kickball.member.domain.Member;

public class MemberFixture {

	public static Member getMember() {
		return new Member("abc@nvaer.com", "123456", "kakao");
	}
}
