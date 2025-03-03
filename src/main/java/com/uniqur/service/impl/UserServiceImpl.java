package com.uniqur.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniqur.entity.User;
import com.uniqur.repository.UserRepository;
import com.uniqur.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUsers(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public List<User> showAllUsers() {
		return this.userRepository.findAll();
	}
	

}
