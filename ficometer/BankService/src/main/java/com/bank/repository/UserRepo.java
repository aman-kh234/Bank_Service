package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.modal.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
	public User findByEmail(String email);
}
