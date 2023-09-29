package com.kickball.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kickball.domain.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
