package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Films;
import com.example.demo.service.FilmsService;

@RestController
@RequestMapping("/film")
public class FilmsController {

	@Autowired
	FilmsService filmsService;
	
	//localhost:8080/film
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Films addFilms (@RequestBody Films film) {
		return filmsService.addFilms(film);
	}
	
	//localhost:8080/film/updatefilm
	@PutMapping("/updatefilm")
	public ResponseEntity<String> updateFilm(@RequestBody Films film){
		try {
			filmsService.updateFilms(film);
			return new ResponseEntity<String>("Data film berhasil diupdate",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	//localhost:8080/film/id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFilm(@PathVariable int id){
		try {
			filmsService.deleteUserbyId(id);
			return new ResponseEntity<String>("Data film berhasil didelete",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	//localhost:8080/film/sedangtayang
	@GetMapping("/sedangtayang")
	public List<Films> getAllFilms(Boolean is_Tayang){
		return filmsService.getAllFilms();
	}
	
	
	//localhost:8080/film/
	@GetMapping("/")
	public List<Films> getAllFilms(){
		return filmsService.getAllFilms();	
	}
}
