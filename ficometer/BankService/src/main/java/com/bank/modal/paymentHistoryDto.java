package com.bank.modal;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class paymentHistoryDto {
	private int id;
	private LocalDate paidOn;
	private long amountPaid;
	private LocalDate dueDate;
	private double minimumEmi;
	
	 private CreditAccountDto creditAccount;
}