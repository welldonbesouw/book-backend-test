package com.technical_test.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical_test.backend.model.Transaction;
import com.technical_test.backend.service.MemberService;
import com.technical_test.backend.service.TransactionService;

@RestController
@RequestMapping("/api/trx")
public class TransactionsController {
	@Autowired
	TransactionService trxService;
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("/borrow/{memberCode}/{bookCode}")
	public ResponseEntity<String> borrowBook(@PathVariable String memberCode, @PathVariable String bookCode){
		Transaction transaction  = trxService.borrowBook(memberCode, bookCode);
		
		return ResponseEntity.ok(transaction.getMessage());
	}
	
	@PostMapping("/return/{trxId}")
	public ResponseEntity<String> returnBook(@PathVariable Long trxId){
		Transaction transaction = trxService.returnBook(trxId);
		
		return ResponseEntity.ok(transaction.getMessage());
	}
	
}
