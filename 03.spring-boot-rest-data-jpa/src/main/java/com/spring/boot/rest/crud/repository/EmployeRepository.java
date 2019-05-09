package com.spring.boot.rest.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.rest.crud.entity.Employee;

public interface EmployeRepository extends JpaRepository<Employee, Integer> {
	

}
