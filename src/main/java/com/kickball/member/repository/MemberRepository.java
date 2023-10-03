package com.kickball.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kickball.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
