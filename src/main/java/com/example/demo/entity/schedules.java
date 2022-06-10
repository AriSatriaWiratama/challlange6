package com.example.demo.entity;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="schedules")
public class schedules {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="idschedules")
	private int idschedules;
	
	@Column (name="filmcode")
	private int filmcode;
	
	@Column (name="tanggal_tayang")
	private LocalDate tanggal_tayang;
	
	@Column (name="jam_mulai")
	private Time jam_mulai;
	
	@Column (name="jam_selesai")
	private Time jam_selesai;
	
	@Column (name="harga_tiket")
	private float harga_tiket;

	public int getIdschedules() {
		return idschedules;
	}

	public void setIdschedules(int idschedules) {
		this.idschedules = idschedules;
	}

	@ManyToOne
	@JoinColumn(name ="filmcode")
	public int getFilmcode() {
		return filmcode;
	}

	public void setFilmcode(int filmcode) {
		this.filmcode = filmcode;
	}

	public LocalDate getTanggal_tayang() {
		return tanggal_tayang;
	}

	public void setTanggal_tayang(LocalDate tanggal_tayang) {
		this.tanggal_tayang = tanggal_tayang;
	}

	public Time getJam_mulai() {
		return jam_mulai;
	}

	public void setJam_mulai(Time jam_mulai) {
		this.jam_mulai = jam_mulai;
	}

	public Time getJam_selesai() {
		return jam_selesai;
	}

	public void setJam_selesai(Time jam_selesai) {
		this.jam_selesai = jam_selesai;
	}

	public float getHarga_tiket() {
		return harga_tiket;
	}

	public void setHarga_tiket(float harga_tiket) {
		this.harga_tiket = harga_tiket;
	}
	
}
