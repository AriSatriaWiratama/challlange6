package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Films;
import com.example.demo.repo.FilmsRepository;
import com.example.demo.service.FilmsService;

@Service
public class FilmsServiceImpl implements FilmsService {

	@Autowired
	private FilmsRepository film_repo;
	
	@Override
	public Films addFilms(Films film) {
		// TODO Auto-generated method stub
		return film_repo.save(film);
	}

	@Override
	public void updateFilms(Films film) {
		// TODO Auto-generated method stub
		Films filmDB = film_repo.findById(film.getFilmcode()).orElseThrow();
		if (filmDB != null) {
			film_repo.save(film);
		}
	}

	@Override
	public void deleteUserbyId(int filmcode) {
		// TODO Auto-generated method stub
		try {
			film_repo.deleteById(filmcode);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Films> getAllFilms(Boolean is_tayang) {
		// TODO Auto-generated method stub
		return film_repo.findAll();
	}

	@Override
	public List<Films> getAllFilms() {
		// TODO Auto-generated method stub
		return film_repo.findAll();
	}

}
