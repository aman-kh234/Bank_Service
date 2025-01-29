package com.bank.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class typeOfCreditDto {
	private int id;
	private String label;
	
	private CreditAccountDto creditAccount;
}
