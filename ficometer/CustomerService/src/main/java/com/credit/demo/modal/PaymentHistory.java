package com.credit.demo.modal;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class PaymentHistory {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentHistory_seq")
    @SequenceGenerator(name = "paymentHistory_seq", sequenceName = "paymentHistory_sequence", allocationSize = 1)
    private int id;

    @Column(nullable = false)
    private LocalDate paidOn;

    @Column(nullable = false)
    private double amountPaid;

    @Column(nullable = false)
    private double minEmi;

    @Column(nullable = false)
    private LocalDate dueDate;}
