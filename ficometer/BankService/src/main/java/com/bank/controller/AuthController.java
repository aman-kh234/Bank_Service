package com.bank.controller;

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

import com.bank.config.JwtProvider;
import com.bank.modal.User;
import com.bank.repository.UserRepo;
import com.bank.request.LoginRequest;
import com.bank.response.AuthResponse;
import com.bank.serviceImpl.CustomUserServiceImpl;
 
 
@RestController
@RequestMapping("/auth/bank")
public class AuthController {
	@Autowired
	private UserRepo userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CustomUserServiceImpl customUserDetails;
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws Exception{
		String email = user.getEmail();
		String password = user.getPassword();
		String fullName = user.getFullName();
		String role = user.getRole();
		User emailExist = userRepository.findByEmail(email);
		if(emailExist!=null) {
			throw new Exception("Email is already used");
		}
		User createdUser = new User();
		createdUser.setEmail(email);
		createdUser.setFullName(fullName);
		createdUser.setRole(role);
		createdUser.setPassword(passwordEncoder.encode(password));
 
		User savedUser = userRepository.save(createdUser);

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
