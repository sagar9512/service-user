package com.user.service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.model.User;
import com.user.service.service.UserService;

@RestController
@RequestMapping("/api/v1/service-user")
public class UserManagerController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/fetch/user/{userId}")
	public Optional<User> findUserByUserId(@PathVariable Long userId) {
		return userService.fetchUserById(userId);
		
	}
	

}
