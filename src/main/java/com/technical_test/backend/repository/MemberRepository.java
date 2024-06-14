package com.technical_test.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technical_test.backend.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByCode(String memberCode);
}
