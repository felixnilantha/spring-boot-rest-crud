package com.spring.boot.rest.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.rest.crud.entity.Employee;

@Repository
public class EmployeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		Session session = entityManager.unwrap(Session.class);

		Query<Employee> query = session.createQuery("from Employee", Employee.class);

		List<Employee> listEmployees = query.getResultList();

		return listEmployees;
	}

	@Override
	public Employee findById(int id) {
		
		Session session = entityManager.unwrap(Session.class);

		Employee employee = session.get(Employee.class, id);

		return employee;

	}

	@Override
	public void save(Employee employee) {
		
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);

	}

	@Override
	public void delete(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		@SuppressWarnings("unchecked")
		Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();

	}

}
