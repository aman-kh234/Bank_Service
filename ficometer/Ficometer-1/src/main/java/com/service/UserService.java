package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Customer;

@Service
public interface UserService {
	public Customer getUserProfile(String jwt);
	public List<Customer> getAllUser(); 
}