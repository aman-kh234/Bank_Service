package com.bank.modal;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditAccountDto {
	private int id;
	private LocalDate createdAt;
	private typeOfCreditDto typeOfCredit;
	private long creditLimit;
	private long creditUsed;
	private paymentHistoryDto paymentHistory;
}
