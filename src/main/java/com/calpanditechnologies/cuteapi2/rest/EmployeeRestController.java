package com.calpanditechnologies.cuteapi2.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.calpanditechnologies.cuteapi2.dao.EmployeeDAO;
import com.calpanditechnologies.cuteapi2.entity.Employee;
import com.calpanditechnologies.cuteapi2.service.EmployeeService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	//private EmployeeDAO employeeDAO;
	
	private EmployeeService employeeService;
	
	/*private EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		this.employeeDAO = theEmployeeDAO;
	}*/
	
	@Autowired
	private EmployeeRestController(EmployeeService theEmployeeService) {
		this.employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		//return this.employeeDAO.findAll();
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = this.employeeService.findById(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("Employeeid not found " + employeeId);
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		Employee newEmployee = this.employeeService.save(employee);
		return newEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee updatedEmployee = this.employeeService.save(employee);
		return updatedEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee foundEmployee = this.employeeService.findById(employeeId);
		if(foundEmployee == null) {
			throw new RuntimeException("EmployeeId not found " + employeeId);
		}

		this.employeeService.deleteById(employeeId);
		
		return "Deleted employeeId " + employeeId;
	}
	
}
