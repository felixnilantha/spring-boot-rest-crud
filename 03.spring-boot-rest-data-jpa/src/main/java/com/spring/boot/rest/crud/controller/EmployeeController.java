package com.spring.boot.rest.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.rest.crud.entity.Employee;
import com.spring.boot.rest.crud.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	private EmployeeService service;

	@Autowired
	public EmployeeController(EmployeeService service) {

		this.service = service;
	}

	@GetMapping("/list")
	public List<Employee> findAll() {
		return service.findAll();
	}

	@GetMapping("/get/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee employee = service.findById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Employee id : " + employeeId + " not found");
		}

		return employee;
	}

	@PostMapping("/create")
	public Employee save(@RequestBody Employee employee) {

		employee.setId(0);

		service.save(employee);

		return employee;
	}

	@PutMapping("/update")
	public Employee update(@RequestBody Employee employee) {

		service.save(employee);

		return employee;
	}

	@DeleteMapping("/delete/{employeeId}")
	public String update(@PathVariable int employeeId) {

		Employee employee = service.findById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Employee id : " + employeeId + " not found");
		}

		service.delete(employeeId);;

		return "Deleted employee, with the id : " + employeeId;
	}

}
