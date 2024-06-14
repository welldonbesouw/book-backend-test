package com.technical_test.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical_test.backend.model.Book;
import com.technical_test.backend.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BooksController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/available")
	public ResponseEntity<List<Book>> getAvailableBooks() {
		List<Book> availableBooks = bookService.findAvailableBooks();
		
		return ResponseEntity.ok(availableBooks);
	}
}
