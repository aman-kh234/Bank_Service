package com.bank.modal;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq")
    @SequenceGenerator(name = "loan_seq", sequenceName = "loan_sequence", allocationSize = 1)
    private int id;
	private String loanType;
	
	// Foreign Key
	private int customerId;
	
	private double LoanAmount;
	private double interestRate;
	private int tenure;
	private double emiAmount;
}
