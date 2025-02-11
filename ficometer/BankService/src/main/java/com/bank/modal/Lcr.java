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
public class Lcr {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lcr_seq")
    @SequenceGenerator(name = "lcr_seq", sequenceName = "lcr_sequence", allocationSize = 1)
    private int id;
	
	private double Hqla;
	private double cashOutflow;
	private double cashInflow;
	private LocalDate period;
}
