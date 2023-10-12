package com.kickball.member.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.kickball.common.exception.AuthenticationFailedException;
import com.kickball.member.domain.Member;
import com.kickball.member.fixture.MemberFixture;
import com.kickball.member.repository.MemberRepository;

@Transactional
@SpringBootTest
class MemberLoginServiceTest {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberLoginService memberLoginService;

	@Test
	void 로그인_테스트() {
		//given
		Member member = MemberFixture.getMember();
		memberRepository.save(member);
		String username = member.getUsername();
		String password = member.getPassword();

		//when & then
		assertDoesNotThrow(() -> memberLoginService.login(username, password));
	}

	@Test
	void 로그인_실패_테스트_아이디_틀렸을시() {
		//given
		Member member = MemberFixture.getMember();
		memberRepository.save(member);
		String username = "wrong";
		String password = member.getPassword();

		//when & then
		assertThrows(AuthenticationFailedException.class, () -> memberLoginService.login(username, password));
	}

	@Test
	void 로그인_실패_테스트_패스워드_틀렸을시() {
		//given
		Member member = MemberFixture.getMember();
		memberRepository.save(member);
		String username = member.getUsername();
		String password = "wrong";

		//when & then
		assertThrows(AuthenticationFailedException.class, () -> memberLoginService.login(username, password));
	}

}