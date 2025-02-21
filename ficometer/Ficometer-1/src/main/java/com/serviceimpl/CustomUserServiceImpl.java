package com.serviceimpl;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.model.Customer;
import com.repo.ICustomerRepo;


@Service
public class CustomUserServiceImpl implements UserDetailsService{
	@Autowired
	private ICustomerRepo userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer user = userRepository.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("user not found with email "+ user.getEmail());
		}
		List<GrantedAuthority> authorities = new ArrayList();
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
}