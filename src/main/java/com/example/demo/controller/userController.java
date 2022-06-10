package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.userService;

@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	userService UserService;
	
	//localhost:8080/user
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		return UserService.addUser(user);
	}
	
	//localhost:8080/user/updateuser
	@PutMapping("/updateuser")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		try {
			UserService.updateUser(user);
			return new ResponseEntity<String>("Data user berhasil diupdate",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	//localhost:8080/user/id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		try {
			UserService.deleteUserbyId(id);
			return new ResponseEntity<String>("Data user berhasil didelete",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
}

