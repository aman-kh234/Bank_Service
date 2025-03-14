package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.JwtProvider;
import com.config.request.LoginRequest;
import com.config.response.AuthResponse;
import com.model.CreditAccount;
import com.model.CreditEnquiries;
import com.model.Customer;
import com.repo.ICustomerRepo;
import com.service.CustomerService;
import com.serviceimpl.CustomUserServiceImpl;

 
 
@RestController
@RequestMapping("/auth/customer")
public class AuthController {
	@Autowired
	private ICustomerRepo userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CustomUserServiceImpl customUserDetails;
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody Customer user) throws Exception{
		String email = user.getEmail();
		String password = user.getPassword();
		String name = user.getName();
		int age = user.getAge();
		long mobile = user.getMobile();
		String occupation = user.getOccupation();
		double income = user.getIncome();
		List<CreditAccount> creditAccounts = user.getCreditAccount();
		List<CreditEnquiries> creditEnquiries = user.getCreditEnquiries();
		
		Customer emailExist = userRepository.findByEmail(email);
		
		if(emailExist!=null) {
			throw new Exception("Email is already used");
		}
		Customer createdUser = new Customer();
		createdUser.setName(name);
		createdUser.setEmail(email);
		createdUser.setAge(age);
		createdUser.setMobile(mobile);
		createdUser.setOccupation(occupation);
		createdUser.setIncome(income);
		createdUser.setCreditAccount(creditAccounts);
		createdUser.setCreditEnquiries(creditEnquiries);
		createdUser.setPassword(passwordEncoder.encode(password));
 
		Customer savedUser = userRepository.save(createdUser);

		Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = JwtProvider.generateToken(authentication);
		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(token);
		authResponse.setMessage("Register Success");
		authResponse.setStatus(true);
		return new ResponseEntity<>(authResponse, HttpStatus.OK);
	}
	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest req) throws Exception{
		String email = req.getEmail();
		String password = req.getPassword();
		Authentication authentication = authenticate(email,password); 
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = JwtProvider.generateToken(authentication);
		AuthResponse authResponse = new AuthResponse();
		authResponse.setMessage("Login Success");
		authResponse.setJwt(token);
		authResponse.setStatus(true);
		return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.OK);
	}
 
	private Authentication authenticate(String username, String password) throws Exception {
	    UserDetails userDetails = customUserDetails.loadUserByUsername(username);
 
	    System.out.println("sign in userDetails = " + userDetails);
 
	    if (userDetails == null) {
	        System.out.println("sign in userDetails null = " + userDetails); 
	        throw new BadCredentialsException("Invalid username or password"); 
	    }
 
	    if (!passwordEncoder.matches(password, userDetails.getPassword())) {
	        System.out.println("sign in userDetails password not match = " + userDetails); 
	        throw new BadCredentialsException("Invalid username or password"); 
	    }
 
	    return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}
}