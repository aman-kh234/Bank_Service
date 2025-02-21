package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.LoanImpactRequest;
import com.dto.LoanImpactResponse;
import com.model.LoanEntity;
import com.repo.LoanRepository;

@Service
public class LoanImpactService {

    @Autowired
    private LoanRepository loanRepository;

    public LoanImpactResponse predictImpact(LoanImpactRequest request) {
        double impact = calculateCreditImpact(request);
        String explanation = generateExplanation(impact);

        // Optionally, store loan details for future model training
        LoanEntity loan = new LoanEntity(request.getAmount(), request.getTerm(), request.getInterestRate(), impact);
        loanRepository.save(loan);

        return new LoanImpactResponse(impact, explanation);
    }

    private double calculateCreditImpact(LoanImpactRequest request) {
        // Dummy logic: Higher loan and interest rate → More impact
        return -(request.getAmount() * 0.01) - (request.getInterestRate() * 0.5);
        
    }

    private String generateExplanation(double impact) {
        if (impact < -50) {
            return "High risk: Large loan amount and high interest rate affect credit score significantly.";
        } else if (impact < -20) {
            return "Moderate risk: Loan affects credit score moderately.";
        } else {
            return "Low risk: Loan impact is minimal.";
        }
    }
}
