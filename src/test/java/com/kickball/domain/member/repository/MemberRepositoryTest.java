package com.kickball.domain.member.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.kickball.domain.member.domain.Member;

@DataJpaTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private TestEntityManager em;

	@Test
	public void 회원저장_조회_테스트() {
		Member member = getFixture();

		Member savedMember = memberRepository.save(member);

		em.clear();

		Member foundMember = memberRepository.findById(savedMember.getId()).orElse(null);

		assertNotNull(foundMember);
		memberEquals(member, foundMember);
		memberEquals(savedMember, foundMember);
	}

	@Test
	public void 회원_삭제_테스트() {
		Member member = getFixture();

		Member savedMember = memberRepository.save(member);

		memberRepository.delete(savedMember);

		assertTrue(memberRepository.findById(savedMember.getId()).isEmpty());
	}

	private static void memberEquals(Member expected, Member actual) {
		assertEquals(expected.getUsername(), actual.getUsername());
		assertEquals(expected.getRole(), actual.getRole());
		assertEquals(expected.getPassword(), actual.getPassword());
		assertEquals(expected.getProvider(), actual.getProvider());
	}

	private Member getFixture() {
		return new Member("base6666@naver.com", "12345", "kakao");
	}
}