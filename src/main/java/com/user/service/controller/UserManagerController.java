package com.user.service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.model.User;
import com.user.service.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/service-user")
@Api(value = "User Rest Controller", description = "REST API for User")
public class UserManagerController {

	@Autowired
	UserService userService;

	@PostMapping("/insert/user")
	public String findUserByUserId(@RequestBody User userInsertRequest) {
		return userService.saveUser(userInsertRequest) > 1 ? "User Inserted" : "Unable to add user";

	}
	
	@GetMapping("/fetch/user/{userId}")
	public Optional<User> findUserByUserId(@PathVariable int userId) {
		return userService.fetchUserById(userId);

	}

}
