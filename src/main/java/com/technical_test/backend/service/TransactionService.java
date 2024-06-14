package com.technical_test.backend.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical_test.backend.model.Book;
import com.technical_test.backend.model.Member;
import com.technical_test.backend.model.Transaction;
import com.technical_test.backend.repository.BookRepository;
import com.technical_test.backend.repository.MemberRepository;
import com.technical_test.backend.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository trxRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	MemberRepository memberRepo;
	
	public Transaction borrowBook(String memberCode, String bookCode) {
		Member member = getMemberByCode(memberCode);
		Transaction transaction = new Transaction();
		transaction.setMessage("Your request cannot be fulfilled.");;

		if(member.getPenaltyEndDate() == null) {
			if(member.getBorrowedBook() < 2) {
				Optional<Book> book = Optional.ofNullable(bookRepo.findByCode(bookCode).orElseThrow(null));

				if(book.get().getStock() > 0) {
					transaction.setMember(member);
					transaction.setBorrowedBook(book.get());
					LocalDate returnDate = LocalDate.now().plusDays(7);
					transaction.setReturnDate(returnDate);
					
					member.setBorrowedBook(member.getBorrowedBook()+1);
					book.get().setStock(book.get().getStock()-1);
					
					transaction.setMessage("Member " + member.getName() + " successfully borrows " + book.get().getTitle() + " book.");
					
					trxRepo.save(transaction);
					bookRepo.save(book.get());
					memberRepo.save(member);
				}
			}
		}
		
		return transaction;
	}
	
	public Transaction returnBook(Long trxId) {
		Transaction transaction = trxRepo.getReferenceById(trxId);
		Member member = transaction.getMember();
		Book book = transaction.getBorrowedBook();
		member.setBorrowedBook(member.getBorrowedBook()-1);
		book.setStock(book.getStock()+1);
		
		if(LocalDate.now().isAfter(transaction.getReturnDate())) {
			member.setPenaltyEndDate(LocalDate.now().plusDays(3));
		}
		
		transaction.setMessage("Book " + book.getTitle() + " has been successfully returned.");
		trxRepo.save(transaction);
		memberRepo.save(member);
		bookRepo.save(book);
		
		return transaction;
	}
	
	public Member getMemberByCode(String memberCode) {
		Member member = memberRepo.findByCode(memberCode);
		
		return member;
	}
}
