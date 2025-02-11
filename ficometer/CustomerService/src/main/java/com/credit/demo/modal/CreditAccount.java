package com.credit.demo.modal;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class CreditAccount {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "creditAccount_seq")
    @SequenceGenerator(name = "creditAccount_seq", sequenceName = "creditAccount_sequence", allocationSize = 1)
    private int creditAccountId;
	
	@Column(nullable = false)
	private double creditLimit;
	
	@Column(nullable = false)
	private double creditUsed;
	
	@Column(nullable = false)
	private LocalDateTime createdOn;
	
	// payment history class one to many
}
