package com.employee.app.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.employee.app.employee.model.Employee;
import com.employee.app.employee.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner sampleData(EmployeeRepository empRepository) {
		return arg -> {
			empRepository.save(new Employee(1,"Shanthi","Paladugu",
					"shanthi.pal@gmail.com",26,6500000));
		};
	}
}
