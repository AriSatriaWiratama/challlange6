package com.example.demo.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/report")
public class ReportController {
	@Autowired
	private ReportService reportService;
	
	@GetMapping
	private String generate() throws JRException, FileNotFoundException {
		return reportService.generateReport();
	}
}
