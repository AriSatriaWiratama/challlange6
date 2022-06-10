package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Films;

public interface FilmsService {
	Films addFilms (Films film);
	void updateFilms(Films film);
	void deleteUserbyId(int filmcode);
	List<Films> getAllFilms(Boolean is_Tayang);

	List<Films> getAllFilms();

}
