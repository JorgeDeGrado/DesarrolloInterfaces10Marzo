package com.example.accdat_2ev.service;

import com.example.accdat_2ev.model.Item;
import com.example.accdat_2ev.repository.ItemRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private ItemRepository itemRepository;

    public String generateReport() throws JRException {
        List<Item> items = itemRepository.findAll();
        File file = new File("src/main/resources/templates/report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(items);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Spring Boot");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "items_report.pdf");

        return "items_report.pdf";
    }
}
