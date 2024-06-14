package com.technical_test.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical_test.backend.model.Member;
import com.technical_test.backend.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MembersController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Member>> getAllMembers(){
		List<Member> allMembers = memberService.getAllMembers();
		
		return ResponseEntity.ok(allMembers);
	}
}
