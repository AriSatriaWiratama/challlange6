package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.serviceImpl.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    UserLoginServiceImpl userLoginService;

    @PostMapping("/registration")
    public ResponseEntity<?> registration (@RequestBody User user ){
        Map <String, String> map = new HashMap<>();
        User userLogin = userLoginService.findByUsername(user.getUsername());
        if (userLogin !=null){
            map.put(user.getUsername(), "username already exist");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }else {
            userLoginService.saveUser(user);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
