package com.bank.modal;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	private int id;
	private String name;
	private String email;
	private int age;
	private long mobile;
	
	private String occupation;	
	private double income;
}
