package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {

}
