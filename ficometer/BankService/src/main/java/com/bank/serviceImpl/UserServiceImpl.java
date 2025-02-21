package com.bank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.config.JwtProvider;
import com.bank.modal.User;
import com.bank.repository.UserRepo;
import com.bank.service.UserService;
 
 
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepo userRepository;
	@Override
	public User getUserProfile(String jwt) {
		String email = JwtProvider.getEmailFromJwtToken(jwt);
		User user = userRepository.findByEmail(email);
		return user;
	}
 
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
}