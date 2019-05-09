package com.spring.boot.rest.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.rest.crud.entity.Employee;

@Repository
public class EmployeDaoJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeDaoJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		@SuppressWarnings("unchecked")
		Query<Employee> query = (Query<Employee>) entityManager.createQuery("from Employee");

		List<Employee> listEmployees = query.getResultList();

		return listEmployees;
	}

	@Override
	public Employee findById(int id) {

		Employee employee = entityManager.find(Employee.class, id);

		return employee;

	}

	@Override
	public void save(Employee employee) {

		Employee mergeEmployee = entityManager.merge(employee);
		/// update the id
		employee.setId(mergeEmployee.getId());

	}

	@Override
	public void delete(int id) {


		@SuppressWarnings("unchecked")
		Query<Employee> query = (Query<Employee>) entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();

	}

}
