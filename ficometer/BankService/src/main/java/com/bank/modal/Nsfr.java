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
public class Nsfr {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nsfr_seq")
    @SequenceGenerator(name = "nsfr_seq", sequenceName = "nsfr_sequence", allocationSize = 1)
    private int id;
	private double availableStableFund;
	private double requiredStableFund;
	private LocalDate period;
}
