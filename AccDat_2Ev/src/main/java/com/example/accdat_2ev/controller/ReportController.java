package com.example.accdat_2ev.controller;

import com.example.accdat_2ev.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public String generateReport() {
        try {
            return reportService.generateReport();
        } catch (JRException e) {
            return "Error al generar el informe";
        }
    }
}
