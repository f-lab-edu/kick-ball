package com.kickball.member.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.kickball.common.exception.UsernameAlreadyExistsException;
import com.kickball.member.domain.Member;
import com.kickball.member.fixture.MemberFixture;
import com.kickball.member.repository.MemberRepository;

@Transactional
@SpringBootTest
class MemberJoinServiceTest {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberJoinService memberJoinService;

	@Test
	void 회원가입_테스트() {
		//given
		Member member = MemberFixture.getMember();

		//when & then
		assertDoesNotThrow(() -> memberJoinService.join(member));
	}

	@Test
	void 회원가입_테스트_이미_가입된_username() {
		//given
		Member member = MemberFixture.getMember();
		memberJoinService.join(member);

		//when & then
		assertThrows(UsernameAlreadyExistsException.class, () -> memberJoinService.join(member));
	}

}