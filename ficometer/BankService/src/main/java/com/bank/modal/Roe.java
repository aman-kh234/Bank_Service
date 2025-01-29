package com.bank.modal;

import java.time.LocalDate;
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
public class Roe {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roe_seq")
    @SequenceGenerator(name = "roe_seq", sequenceName = "roe_sequence", allocationSize = 1)
    private int id;
	private double shareHolderEquity;
	private double netIncome;
	private LocalDate period;
}
