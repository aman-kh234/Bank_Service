package com.dto;

public class LoanImpactRequest {
    private double amount;
    private int term;
    private double interestRate;

    // Constructors, Getters, and Setters
    public LoanImpactRequest() {}

    public LoanImpactRequest(double amount, int term, double interestRate) {
        this.amount = amount;
        this.term = term;
        this.interestRate = interestRate;
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
}
