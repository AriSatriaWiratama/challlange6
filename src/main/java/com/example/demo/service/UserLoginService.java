package com.example.demo.service;


import com.example.demo.entity.User;

public interface UserLoginService {
    public User findByUsername(String username);
    public User saveUser(User user);
}