package com.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dto.LoginCustomerDto;
import com.dto.RegisterCustomerDto;
import com.dto.UpdateCustomerDto;
import com.model.Customer;
import com.repo.ICustomerRepo;

 
@Service
public class CustomerService2 {
	private ICustomerRepo customerRepository;
	private PasswordEncoder passwordEncoder;

	public Customer findByUsername(String username) {
        return customerRepository.findByEmail(username);
    }
	public Customer add(Customer user) {
		return customerRepository.saveAndFlush(user);
	}
	public Customer update(Customer user) {
		return customerRepository.saveAndFlush(user);
	}
	public Customer getById(int id) {
		return customerRepository.findById(id).get();
	}

 
	public Customer signup(Customer input) {
		
    	long timestamp = Instant.now().toEpochMilli();
    	System.out.println(passwordEncoder.encode(input.getPassword()));
    	
    	input.setPassword(passwordEncoder.encode(input.getPassword()));
 

        return customerRepository.save(input);
    }

    public List<Customer> allUsers() {
        List<Customer> users = new ArrayList();
        customerRepository.findAll().forEach(users::add);
        customerRepository.findAll().forEach(System.out::println);
        return users;
    }

    public Customer updateUser(String email, UpdateCustomerDto newUser) {
    	Customer user = customerRepository.findByEmail(email);
    	user.setName(newUser.getName());
    	
//    	user.setProfileImg(newUser.getProfileImgUrl());
    	return customerRepository.save(user);
    }
	}	
	