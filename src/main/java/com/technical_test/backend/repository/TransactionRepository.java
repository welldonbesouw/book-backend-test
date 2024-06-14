package com.technical_test.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technical_test.backend.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
