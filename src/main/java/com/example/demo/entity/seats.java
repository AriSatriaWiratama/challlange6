package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SEATS")

public class seats {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_name")
    private Character studio_name ;
    @Column(name="nomor_kursi")
    private int nomor_kursi;

    public Character getStudio_name() {
        return studio_name;
    }
    public void setStudio_name(Character studio_name) {
        this.studio_name = studio_name;
    }
    public int getNomor_kursi() {
        return nomor_kursi;
    }
    public void setNomor_kursi(int nomor_kursi) {
        this.nomor_kursi = nomor_kursi;
    }
}
