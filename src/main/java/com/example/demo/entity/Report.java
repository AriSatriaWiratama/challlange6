package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Report {
	@Id
	private int filmcode;
	private String filmname;
	private boolean is_tayang;
	private String username;
	public int getFilmcode() {
		return filmcode;
	}
	public void setFilmcode(int filmcode) {
		this.filmcode = filmcode;
	}
	public String getFilmname() {
		return filmname;
	}
	public void setFilmname(String filmname) {
		this.filmname = filmname;
	}
	public boolean isIs_tayang() {
		return is_tayang;
	}
	public void setIs_tayang(boolean is_tayang) {
		this.is_tayang = is_tayang;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
