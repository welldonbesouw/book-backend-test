package com.technical_test.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technical_test.backend.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	Optional<Book> findByCode(String code);
}
