package com.calpanditechnologies.cuteapi2.service;

import java.util.List;

import com.calpanditechnologies.cuteapi2.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
