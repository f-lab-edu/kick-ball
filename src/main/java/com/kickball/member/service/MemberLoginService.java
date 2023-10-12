package com.kickball.member.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kickball.common.exception.AuthenticationFailedException;
import com.kickball.common.exception.UsernameAlreadyExistsException;
import com.kickball.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberLoginService {

	private final MemberRepository memberRepository;

	public void login(String username, String password) {
		memberRepository.findByUsernameAndPassword(username, password)
			.orElseThrow(() -> new AuthenticationFailedException());
	}
}
