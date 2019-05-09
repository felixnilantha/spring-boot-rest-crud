package com.spring.boot.rest.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.rest.crud.dao.EmployeeDAO;
import com.spring.boot.rest.crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO dao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		return dao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {

		return dao.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		dao.save(employee);
	}

	@Override
	@Transactional
	public void delete(int id) {
		dao.delete(id);
	}

}
