package com.capg.hcms.register_management_system.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcms.register_management_system.model.User;

public interface IRegisterRepository extends JpaRepository<User, String> {

	public User getUserByUserName(String userName);
	
	public User getUserByContactNumber(BigInteger contactNumber);
	
	public User getUserByUserEmail(String userEmail);
}