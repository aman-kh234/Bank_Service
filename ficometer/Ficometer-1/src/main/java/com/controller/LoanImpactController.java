package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dto.LoanImpactRequest;
import com.dto.LoanImpactResponse;
import com.model.Customer;
import com.service.UserService;
import com.serviceimpl.LoanImpactService;

@RestController
@RequestMapping("/loan")
public class LoanImpactController {

    @Autowired
    private LoanImpactService loanImpactService;
    @Autowired
	private UserService userService;
    
    @PostMapping("/predict-impact")
    public ResponseEntity<LoanImpactResponse> predictLoanImpact(@RequestHeader("Authorization") String jwt,@RequestBody LoanImpactRequest request) throws Exception {
    	Customer customer = userService.getUserProfile(jwt);
		if(customer==null) {
			throw new Exception("Customer does not exist");
		}
    	try {
            LoanImpactResponse response = loanImpactService.predictImpact(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new LoanImpactResponse("Error processing prediction"));
        }
    }
}

