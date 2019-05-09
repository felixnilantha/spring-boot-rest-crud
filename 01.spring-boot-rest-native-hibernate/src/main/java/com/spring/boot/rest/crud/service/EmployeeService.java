package com.spring.boot.rest.crud.service;

import java.util.List;

import com.spring.boot.rest.crud.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public void delete(int id);

}
