package com.user.service.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.user.service.model.User;

public interface UserDao {
	 Integer saveUser(User user);
	 User fetchUserById(int id);
	 User updateUserDetails(Long id , User user) throws Exception;
	 void deleteUser(Long id)throws Exception;
	 List<User> fetchAllUsers(); 

}
