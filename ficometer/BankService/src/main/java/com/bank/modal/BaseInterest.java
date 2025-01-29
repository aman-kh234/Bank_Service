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
public class BaseInterest {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baseInterest_seq")
    @SequenceGenerator(name = "baseInterest_seq", sequenceName = "baseInterest_sequence", allocationSize = 1)
    private int id;
	private double fixedInterest;
	private double riskPremium;
	private double operationalCost;
	private double profitMargin;
}
