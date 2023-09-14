package io.xdoto.employeeme;

import io.xdoto.employeeme.entity.Employee;
import io.xdoto.employeeme.repository.EmployeeRepository;
import io.xdoto.employeeme.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication

@RestController
public class EmployeemeApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ReportService reportService;

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
		return reportService.exportReport(format);
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeemeApplication.class, args);
	}

}
