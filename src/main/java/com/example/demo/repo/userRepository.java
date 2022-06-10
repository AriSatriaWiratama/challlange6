package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface userRepository extends JpaRepository<User, Integer>{
    public User findByUsername(String username);
}
