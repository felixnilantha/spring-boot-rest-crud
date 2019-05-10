package com.spring.boot.rest.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.boot.rest.crud.entity.Employee;

@RepositoryRestResource(path="members")
public interface EmployeRepository extends JpaRepository<Employee, Integer> {

	
}
