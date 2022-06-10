package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="films")
public class Films {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="filmcode")
	private int filmcode;
	
	@Column(name="filmname")
	private String filmname;
	
	@Column (name="is_tayang")
	private boolean is_tayang;
	
	
	@OneToMany (mappedBy = "filmcode",cascade = CascadeType.ALL)
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
}
