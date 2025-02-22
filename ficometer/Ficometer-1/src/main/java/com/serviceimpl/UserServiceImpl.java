package com.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.JwtProvider;
import com.model.Customer;
import com.repo.ICustomerRepo;
import com.service.UserService;

 
 
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	ICustomerRepo userRepository;
	@Override
	public Customer getUserProfile(String jwt) {
		String email = JwtProvider.getEmailFromJwtToken(jwt);
		Customer user = userRepository.findByEmail(email);
		return user;
	}
 
	@Override
	public List<Customer> getAllUser() {
		return userRepository.findAll();
	}
}