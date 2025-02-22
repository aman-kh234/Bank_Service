package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.model.CreditAccount;
import com.model.Customer;

@Service
public interface CustomerService {

	public Customer addCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public void deleteCustomerById(int id);

	public List<Customer> getAllCustomer();

	public double checkCreditScore(int uid);

	public Long getTotalCustomers();
	
	public void updateCustomer(Customer customer);

	public double paymentHistoryScore(List<CreditAccount> creditAccounts);

	public double creditUtilizationScore(List<CreditAccount> creditAccounts);

	public double accountHistoryScore(List<CreditAccount> creditAccounts);

	public String checkCreditHealth(int uid);

	public double creditInquiriesScore(List<CreditAccount> creditAccounts, Customer customer);

	public double creditMixScore(List<CreditAccount> creditAccounts);
	
	
}
