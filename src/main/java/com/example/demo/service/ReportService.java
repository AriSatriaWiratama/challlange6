package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.example.demo.entity.Report;
import com.example.demo.repo.ReportRepository;

@Service
public class ReportService {
	@Autowired
	private ReportRepository reportRepository;
	
	public String generateReport() throws FileNotFoundException, JdbcUpdateAffectedIncorrectNumberOfRowsException, JRException {
		List<Report> reportList = reportRepository.findAll();
		File file = ResourceUtils.getFile("classpath:Tiket_data.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportList);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Created by", "Ari Satria");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Ticket_Bioskop.pdf");
		
		return "berhasil";
		
	}


}
