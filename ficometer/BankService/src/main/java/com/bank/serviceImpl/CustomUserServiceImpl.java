package com.bank.serviceImpl;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bank.modal.User;
import com.bank.repository.UserRepo;
 
 
 
// no default generated password is there because we have write our own userservice
@Service
public class CustomUserServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepo userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("user not found with email "+ user.getEmail());
		}
		List<GrantedAuthority> authorities = new ArrayList();
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
}