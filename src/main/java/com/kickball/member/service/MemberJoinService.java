package com.kickball.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kickball.common.exception.UsernameAlreadyExistsException;
import com.kickball.member.domain.Member;
import com.kickball.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberJoinService {

	private final MemberRepository memberRepository;

	public void join(Member member) {
		memberRepository.findByUsername(member.getUsername()).ifPresent(existingMember -> {
			throw new UsernameAlreadyExistsException("이미 존재하는 username 입니다.");
		});

		memberRepository.save(member);
	}
}
