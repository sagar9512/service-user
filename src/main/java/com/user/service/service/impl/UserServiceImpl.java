package com.user.service.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.dao.UserDao;
import com.user.service.model.User;
import com.user.service.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public Optional<User> fetchUserById(Long id) {
		return userDao.findById(id);
	}

	@Override
	public User updateUserDetails(Long id, User user) throws Exception {
		Optional<User> userDetails = userDao.findById(id);
		if (userDetails.isPresent()) {
			if (null != user.getEmail()) {
				userDetails.get().setEmail(user.getEmail());
			}
			if (null != user.getFirstName()) {
				userDetails.get().setFirstName(user.getFirstName());
			}
			if (null != user.getLastName()) {
				userDetails.get().setLastName(user.getLastName());
			}
			if (null != user.getPassword()) {
				userDetails.get().setPassword(user.getPassword());
			}
			if (null != user.getRole()) {
				userDetails.get().setRole(user.getRole());
			}
			if (null != user.getUserId()) {
				userDetails.get().setUserId(user.getUserId());
			}
		} else {
			throw new Exception("Bad request");
		}
		return userDao.save(user);
	}

	@Override
	public void deleteUser(Long id) throws Exception {
		userDao.deleteById(id);
	}

	@Override
	public List<User> fetchAllUsers() {
		return userDao.findAll();
	}

}
