package com.bank.modal;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditEnqueriesDto {
	private int id;
	private int score;
	private LocalDate checkedOn;
	private String reportLink;
	private String review;
	private String improvementTips;
}
