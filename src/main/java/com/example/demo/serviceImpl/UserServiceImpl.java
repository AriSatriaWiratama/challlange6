package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.userRepository;
import com.example.demo.service.userService;

@Service
public class UserServiceImpl implements userService{

	@Autowired
	private userRepository user_repo;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return user_repo.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		User UserDB = user_repo.findById(user.getUserId()).orElseThrow();
		if (UserDB != null) {
			user_repo.save(user);	
		}
	}
	@Override
	public void deleteUserbyId(int user_id) {
		// TODO Auto-generated method stub
	try {
		user_repo.deleteById(user_id);
	} catch (Exception e) {
		// TODO: handle exception
		throw new RuntimeException(e.getMessage());
		}	
	}

}
