package com.example.demo.service;

import com.example.demo.entity.User;

public interface userService {
	User addUser(User user);
	void updateUser(User user);
	void deleteUserbyId(int user_id);
	
}
