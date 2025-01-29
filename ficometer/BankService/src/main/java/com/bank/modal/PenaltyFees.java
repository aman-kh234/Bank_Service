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
public class PenaltyFees {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "penaltyFees_seq")
    @SequenceGenerator(name = "penaltyFees_seq", sequenceName = "penaltyFees_sequence", allocationSize = 1)
    private int penaltyId;
	private int delayTime;
	private double feesAmount;
	private LocalDate period;
}
