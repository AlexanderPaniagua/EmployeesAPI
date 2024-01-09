package com.calpanditechnologies.cuteapi2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calpanditechnologies.cuteapi2.dao.EmployeeDAO;
import com.calpanditechnologies.cuteapi2.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		this.employeeDAO = theEmployeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return this.employeeDAO.findAll();
	}

	@Override
	public Employee findById(int theId) {
		return this.employeeDAO.findById(theId);
	}

	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		return this.employeeDAO.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteById(int theId) {
		this.employeeDAO.deleteById(theId);
	}
	
	

}
