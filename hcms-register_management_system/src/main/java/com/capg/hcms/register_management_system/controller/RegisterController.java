package com.capg.hcms.register_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.register_management_system.model.User;
import com.capg.hcms.register_management_system.model.UserList;
import com.capg.hcms.register_management_system.service.IRegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private IRegisterService registerService;
	
	@PostMapping("/adduser")
	public User registerUser(@RequestBody User user) 
	{
		return registerService.registerUser(user);
	}
	
	@GetMapping("/getuser/id/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId)
	{
		return new ResponseEntity<User>(registerService.getUser(userId),HttpStatus.OK);
	}
	
	@GetMapping("/getallusers")
	public UserList getAllUsers()
	{
		return registerService.getAllUsers();
	}
	
}