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
public class Npa {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "npa_seq")
    @SequenceGenerator(name = "npa_seq", sequenceName = "npa_sequence", allocationSize = 1)
    private int id;
	private double nonPerformingAsset;
	private double totalLoan;
	private LocalDate period;
}
