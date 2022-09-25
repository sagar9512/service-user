package com.user.service.service;

import java.util.List;
import java.util.Optional;

import com.user.service.model.User;

public interface UserService {
	
	 Integer saveUser(User user);
	 Optional<User> fetchUserById(int id);
	 User updateUserDetails(Long id , User user) throws Exception;
	 void deleteUser(Long id)throws Exception;
	 List<User> fetchAllUsers(); 
}
