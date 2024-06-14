package com.technical_test.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical_test.backend.model.Member;
import com.technical_test.backend.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepo;

	public Member getMemberByCode(String memberCode) {
		Member member = memberRepo.findByCode(memberCode);
		
		return member;
	}

	public List<Member> getAllMembers() {
		List<Member> allMembers = memberRepo.findAll();

		return allMembers;
	}
}
