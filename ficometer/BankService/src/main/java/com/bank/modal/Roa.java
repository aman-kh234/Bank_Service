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
public class Roa {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roa_seq")
    @SequenceGenerator(name = "roa_seq", sequenceName = "roa_sequence", allocationSize = 1)
    private int id;
	private double totalAssetStart;
	private double totalAssetEnd;
	private double netIncome;
	private LocalDate period;
}
