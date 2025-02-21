package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.CreditAccount;
import com.model.CreditEnquiries;
import com.model.Customer;
import com.model.PaymentHistory;
import com.service.PaymentHistoryService;
import com.service.UserService;
import com.serviceimpl.CreditServiceImpl;
import com.serviceimpl.CustomerServiceImpl;
import com.serviceimpl.PaymentHistoryImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerService;

	@Autowired
	private CreditServiceImpl creditService;
	
	@Autowired
	private PaymentHistoryImpl paymentHistory;
	
	@Autowired
    private PaymentHistoryService paymentHistoryService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public Customer add(@RequestHeader("Authorization") String jwt ,@RequestBody Customer customer) {
	    userService.getUserProfile(jwt);
		return customerService.addCustomer(customer);
	}

	@GetMapping("/{id}")
	public Customer findCustomerById(@PathVariable(name = "id") int id) {
		return customerService.getCustomerById(id);

	}

	@DeleteMapping("/deleteById/{id}")
	public void deleterCustomerById(@RequestHeader("Authorization") String jwt,@PathVariable(name = "id") int id) throws Exception {
		Customer customer = userService.getUserProfile(jwt);
		if(customer==null) {
			throw new Exception("Customer does not exist");
		}
		customerService.deleteCustomerById(customer.getId());
	}

	@GetMapping("/all")
	public List<Customer> getAllCustomer(@RequestHeader("Authorization") String jwt) throws Exception {
		Customer customer = userService.getUserProfile(jwt);
		if(customer==null) {
			throw new Exception("Customer does not exist");
		}
		return customerService.getAllCustomer();
	}
////////////////////////////////////////////CREDIT 
	@PostMapping("/add/credit")
	public ResponseEntity<CreditAccount> addCredit(@RequestHeader("Authorization") String jwt, @RequestBody CreditAccount creditAccount) throws Exception {
		Customer customer = userService.getUserProfile(jwt);
		if(customer==null) {
			throw new Exception("Customer does not exist");
		}
	    // Associate CreditAccount with the Customer
	    creditAccount = creditService.addCredit(creditAccount);
	    customer.getCreditAccount().add(creditAccount);
	    customerService.updateCustomer(customer); // Ensure customer gets updated in DB

	    return ResponseEntity.ok(creditAccount);
	}

	@GetMapping("/score")
	public ResponseEntity<Double> getTotalCreditScore(@RequestHeader("Authorization") String jwt) throws Exception {
	Customer customer = userService.getUserProfile(jwt);
	if(customer==null) {
		throw new Exception("Customer does not exist");
	}
		return ResponseEntity.ok(customerService.checkCreditScore(customer.getId()));
	}
	
	@PostMapping("/add/credit-enquiry")
	public ResponseEntity<Customer> addCreditEnquiry(@RequestHeader("Authorization") String jwt,@RequestBody CreditEnquiries enquiry) {
		Customer customer = userService.getUserProfile(jwt);
	    if (customer == null) {
	        return ResponseEntity.notFound().build();
	    }
	    customer.getCreditEnquiries().add(enquiry);
	    customerService.updateCustomer(customer);
	    return ResponseEntity.ok(customer);
	}

	@PostMapping("/update/payment-history/{creditAccountId}")
	public ResponseEntity<CreditAccount> updatePaymentHistory(@RequestHeader("Authorization") String jwt,@PathVariable int creditAccountId, @RequestBody PaymentHistory payment) throws Exception {
		Customer customer = userService.getUserProfile(jwt);
		if(customer==null) {
			throw new Exception("Customer does not exist");
		}
		CreditAccount creditAccount = creditService.getCreditById(creditAccountId);
	    if (creditAccount == null) {
	        return ResponseEntity.notFound().build();
	    }
	    creditAccount.getPaymentHistory().add(payment);
	    creditService.addCredit(creditAccount);
	    return ResponseEntity.ok(creditAccount);
	}

	

	@GetMapping("/payment-history")
	public ResponseEntity<Double> getPaymentHistoryScore(@RequestHeader("Authorization") String jwt) {
		Customer customer = userService.getUserProfile(jwt);
		
		if (customer == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(customerService.paymentHistoryScore(customer.getCreditAccount()));
	}
	
	@GetMapping("/payment-history/{creditAccountId}")  //accountid
	public ResponseEntity<List<PaymentHistory>> displayPaymentHistory(@RequestHeader("Authorization") String jwt,@PathVariable int creditAccountId) throws Exception {
		//Customer customer = customerService.getCustomerById(aid);
		Customer customer = userService.getUserProfile(jwt);
		if(customer==null) {
			throw new Exception("Customer does not exist");
		}
		List<PaymentHistory> ca=paymentHistory.getPaymentHistory(creditAccountId);
		if (ca == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(ca);
	}
	
	@GetMapping("/payment-history/{creditAccountNumber}")  //accountid
	public ResponseEntity<List<PaymentHistory>> displayPaymentHistory(@RequestHeader("Authorization") String jwt,@PathVariable String creditAccountId) throws Exception {
		//Customer customer = customerService.getCustomerById(aid);
		Customer customer = userService.getUserProfile(jwt);
		if(customer==null) {
			throw new Exception("Customer does not exist");
		}
		List<PaymentHistory> ca=paymentHistory.getPaymentHistory(creditAccountId);
		if (ca == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(ca);
	}
	

	@GetMapping("/credit-utilization")
	public ResponseEntity<Double> getCreditUtilizationScore(@RequestHeader("Authorization") String jwt) throws Exception {
		Customer customer = userService.getUserProfile(jwt);
		
		if (customer == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(customerService.creditUtilizationScore(customer.getCreditAccount()));
	}

	@GetMapping("/credit-health")
	public ResponseEntity<String> getCreditHealthWarning(@RequestHeader("Authorization") String jwt) throws Exception {
		Customer customer = userService.getUserProfile(jwt);
		if(customer==null) {
			throw new Exception("Customer does not exist");
		}
		return ResponseEntity.ok(customerService.checkCreditHealth(customer.getId()));
	}
	
	@GetMapping("/calculate-delayed-payment/{id}")
    public long calculateDelayedPayment(@RequestHeader("Authorization") String jwt,@PathVariable int id) throws Exception {
		Customer customer = userService.getUserProfile(jwt);
		if(customer==null) {
			throw new Exception("Customer does not exist");
		}
        return paymentHistory.calculateDelayedPayment(id);
    }
	
	@PostMapping("/add/payment-history")
    public PaymentHistory addPaymentHistory(@RequestHeader("Authorization") String jwt,@RequestBody PaymentHistory paymentHistory) throws Exception {
		Customer customer = userService.getUserProfile(jwt);
		if(customer==null) {
			throw new Exception("Customer does not exist");
		}
		return paymentHistoryService.addPayment(paymentHistory);
    }
}
