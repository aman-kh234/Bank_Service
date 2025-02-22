package com.bank.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.config.JwtProvider;
import com.bank.exception.UnauthorizedException;
import com.bank.modal.BaseInterest;
import com.bank.modal.Loan;
import com.bank.modal.User;
import com.bank.repository.UserRepo;
import com.bank.service.CustomerService;
import com.bank.service.FeeCalculationService;
import com.bank.service.baseInterest;

@Service
public class FeeCalculationImpl implements FeeCalculationService{

	@Autowired 
	private baseInterest baseInterestService;
    @Autowired
    private CustomerService cs;
    @Autowired
    private JwtProvider jwtProvider;
    
    @Autowired 
    private UserRepo userRepo;
	 public static double calculateRiskIndex(double creditUtilizationRatio, int delayedPayments, double creditScore) {
	        // Weights
	        double w1 = 0.4;
	        double w2 = 0.3;
	        double w3 = 0.3;

	        double riskIndex = (w1 * creditUtilizationRatio) 
	                          + (w2 * delayedPayments) 
	                          + (w3 * (1 - (creditScore / 850.0)));

	        return riskIndex;
	    }

	    public static double calculateFinalInterestRate(double baseInterestRate, double riskIndex, double riskPremiumFactor) {
	        return baseInterestRate + (riskIndex * riskPremiumFactor);
	    }

	    public static double calculateEMI(double loanAmount, double annualInterestRate, int loanTenureMonths) {
	        double monthlyInterestRate = (annualInterestRate / 12) / 100; // Convert annual rate to monthly decimal
	        return (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTenureMonths)) 
	               / (Math.pow(1 + monthlyInterestRate, loanTenureMonths) - 1);
	    }
	    
	@Override
	public double fee_calculated(String jwt,Loan loan) {
			String email = jwtProvider.getEmailFromJwtToken(jwt);
			User user = userRepo.findByEmail(email);
		if(user!=null) {
		    double loanAmount = loan.getLoanAmount(); 
	        int loanTenureMonths = loan.getTenure();
	        double baseInterestRate = baseInterestService.getLatestBaseInterest().getFixedInterest();
	        double riskPremiumFactor = baseInterestService.getLatestBaseInterest().getRiskPremium(); 
	        double creditUtilizationRatio = cs.getCreditUtilizationScore(loan.getCustomerId()); 
	        int delayedPayments = cs.calculateDelayedPayment(loan.getCustomerId());
	        double creditScore = cs.getTotalCreditScore(loan.getCustomerId());

	        //Calculate Risk Index
	        double riskIndex = calculateRiskIndex(creditUtilizationRatio, delayedPayments, creditScore);
	        System.out.println("Risk Index: " + riskIndex);

	        // Adjust Interest Rate
	        double finalInterestRate = calculateFinalInterestRate(baseInterestRate, riskIndex, riskPremiumFactor);
	        System.out.println("Final Adjusted Interest Rate: " + String.format("%.2f", finalInterestRate) + "%");

	        // Calculate EMI
	        double emi = calculateEMI(loanAmount, finalInterestRate, loanTenureMonths);
	        System.out.println("Monthly EMI: ₹" + String.format("%.2f", emi));

	        // Total Loan Repayment
	        double totalRepayment = emi * loanTenureMonths;
	        System.out.println("Total Loan Repayment: ₹" + String.format("%.2f", totalRepayment));
	   
		return finalInterestRate;
		}else {
	        throw new UnauthorizedException("User not authorized");
	    }
	}
	
	

	
}
