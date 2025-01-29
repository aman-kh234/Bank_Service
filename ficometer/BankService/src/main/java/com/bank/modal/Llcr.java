package com.bank.modal;

import java.time.LocalDate;

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
public class Llcr {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "llcr_seq")
    @SequenceGenerator(name = "llcr_seq", sequenceName = "llcr_sequence", allocationSize = 1)
    private int id;
	
	private double loanLossReserves;
	private double nonPerformingLoans;
	private LocalDate period;
}
