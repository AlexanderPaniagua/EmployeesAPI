package com.calpanditechnologies.cuteapi2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.calpanditechnologies.cuteapi2.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// Simple JPA API usage
		
		TypedQuery<Employee> theQuery = this.entityManager.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee employee = this.entityManager.find(Employee.class, theId);
		return employee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		
		Employee employee = this.entityManager.merge(theEmployee);
		
		return employee;
		
	}

	@Override
	public void deleteById(int theId) {
		
		Employee employee = this.entityManager.find(Employee.class, theId);
		
		this.entityManager.remove(employee);
		
	}
	
}
