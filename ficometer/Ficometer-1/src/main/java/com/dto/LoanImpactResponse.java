package com.dto;

public class LoanImpactResponse {
    private double impact;
    private String explanation;

    // Constructors, Getters, and Setters
    public LoanImpactResponse() {}

    public LoanImpactResponse(double impact, String explanation) {
        this.impact = impact;
        this.explanation = explanation;
    }

    public LoanImpactResponse(String explanation) {
        this.impact = 0; // Default impact if there's an error
        this.explanation = explanation;
    }

    public double getImpact() {
        return impact;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}

