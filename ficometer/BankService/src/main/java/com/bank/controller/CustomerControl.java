package com.bank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bank.modal.CustomerDto;
import com.bank.service.CustomerService;

@RestController
@RequestMapping("/bank/customer")
public class CustomerControl {  
    @Autowired  
    private CustomerService cs;  

    @GetMapping("/all")  
    public List<CustomerDto> getAllCustomer() {  
        ResponseEntity<List<CustomerDto>> response = cs.getAllCustomer();  
        return response.getBody();  
    }  
    
    @GetMapping("/count")  
    public Long getTotalCustomers() {  
        return cs.getTotalCustomers();  
    }  
    
}
