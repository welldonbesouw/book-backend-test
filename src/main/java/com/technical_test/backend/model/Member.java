package com.technical_test.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String code;

	private String name;

	@Column(columnDefinition = "integer default 0")
	private int borrowedBook;

	private LocalDate penaltyEndDate;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBorrowedBook() {
		return borrowedBook;
	}
	public void setBorrowedBook(int borrowedBook) {
		this.borrowedBook = borrowedBook;
	}
	public LocalDate getPenaltyEndDate() {
		return penaltyEndDate;
	}
	public void setPenaltyEndDate(LocalDate penaltyEndDate) {
		this.penaltyEndDate = penaltyEndDate;
	}
	
}
