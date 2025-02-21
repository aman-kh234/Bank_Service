package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private int term;
    private double interestRate;
    private double predictedImpact;

    // Constructors, Getters, and Setters
    public LoanEntity() {}

    public LoanEntity(double amount, int term, double interestRate, double predictedImpact) {
        this.amount = amount;
        this.term = term;
        this.interestRate = interestRate;
        this.predictedImpact = predictedImpact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getPredictedImpact() {
        return predictedImpact;
    }

    public void setPredictedImpact(double predictedImpact) {
        this.predictedImpact = predictedImpact;
    }
}
