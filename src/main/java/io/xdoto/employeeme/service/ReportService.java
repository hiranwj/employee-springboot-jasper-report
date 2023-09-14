package io.xdoto.employeeme.service;

import io.xdoto.employeeme.entity.Employee;
import io.xdoto.employeeme.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

        String path = "/home/hiran/Desktop";
        List<Employee> employeeList = employeeRepository.findAll();

        //Load file and compile it
        File file = ResourceUtils.getFile("classpath:employees.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employeeList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy:", "Hiran");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/employees.pdf");
        }

        return "Report generated in path : " + path;
    }
}
