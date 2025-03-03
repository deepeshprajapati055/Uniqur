package com.uniqur.service;

import java.util.List;

import com.uniqur.entity.User;

public interface UserService {
	
	public abstract User saveUsers(User user);
	
	public abstract List<User> showAllUsers();
	
}
