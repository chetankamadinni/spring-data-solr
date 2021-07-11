package io.spring.solr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.solr.model.Employee;
import io.spring.solr.reposiotory.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostConstruct
	public void insertEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		Employee e1 = new Employee(1, "Chetan", "Mudhol");
		Employee e2 = new Employee(2, "Jeevan", "Bangalore");
		Employee e3 = new Employee(3, "Sumit", "Mudhol");
		Employee e4 = new Employee(4, "Harish", "Hyderabad");
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeRepository.saveAll(employeeList);	
	}
	
	
	@GetMapping
	public Iterable<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{name}")
	public Employee getEmployee(@PathVariable String name) {
		return employeeRepository.findByName(name);
	}
	
}
