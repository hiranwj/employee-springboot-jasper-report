package io.xdoto.employeeme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EmployeemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemeApplication.class, args);
	}

}
