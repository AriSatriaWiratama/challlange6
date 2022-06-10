package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Films;

public interface FilmsRepository extends JpaRepository<Films, Integer>{

}
