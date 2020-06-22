package com.employee.app.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.employee.model.Employee;
import com.employee.app.employee.repository.EmployeeRepository;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepository;
	
	
	
	@GetMapping("/employee")
	public List<Employee> getEmployees(){
		return empRepository.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee employee = empRepository.findById(id).orElseThrow();
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return empRepository.save(emp);
	}
	
	@PutMapping("employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		Employee emp = empRepository.findById(id).orElseThrow();
		
		emp.setLastName(employee.getLastName());
		
		Employee updtdEmp = empRepository.save(emp);
		return ResponseEntity.ok().body(updtdEmp);
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable long id) {
		empRepository.findById(id).orElseThrow();
		empRepository.deleteById(id);
	}
	
	
	
	
}
