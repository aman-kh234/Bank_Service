package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dto.LoanImpactRequest;
import com.dto.LoanImpactResponse;
import com.serviceimpl.LoanImpactService;

@RestController
@RequestMapping("/loan")
public class LoanImpactController {

    @Autowired
    private LoanImpactService loanImpactService;

    @PostMapping("/predict-impact")
    public ResponseEntity<LoanImpactResponse> predictLoanImpact(@RequestBody LoanImpactRequest request) {
        try {
            LoanImpactResponse response = loanImpactService.predictImpact(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new LoanImpactResponse("Error processing prediction"));
        }
    }
}

