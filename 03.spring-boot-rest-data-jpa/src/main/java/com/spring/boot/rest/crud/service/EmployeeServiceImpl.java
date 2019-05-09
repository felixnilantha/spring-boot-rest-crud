package com.spring.boot.rest.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.rest.crud.entity.Employee;
import com.spring.boot.rest.crud.repository.EmployeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeRepository repository;

	@Autowired
	public EmployeeServiceImpl(EmployeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Employee> findAll() {

		return repository.findAll();
	}

	@Override
	public Employee findById(int id) {

		Optional<Employee> result = repository.findById(id);

		if (result.isPresent()) {
			return result.get();
		}else {
			throw new RuntimeException("Employee not found : " + id);
		}
	}

	@Override
	public void save(Employee employee) {
		repository.save(employee);
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}

}
