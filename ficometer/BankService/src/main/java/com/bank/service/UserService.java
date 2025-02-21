package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.modal.User;

@Service
public interface UserService {
	public User getUserProfile(String jwt);
	public List<User> getAllUser();
}
