package com.technical_test.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical_test.backend.model.Book;
import com.technical_test.backend.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> findAvailableBooks(){
		List<Book> allBooks = bookRepo.findAll(); 
		List<Book> availableBooks = allBooks.stream().filter(book -> book.getStock() > 0).collect(Collectors.toList());
		
		return availableBooks;
	}
}
