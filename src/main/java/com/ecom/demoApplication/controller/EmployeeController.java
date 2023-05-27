package com.ecom.demoApplication.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecom.demoApplication.entity.Employee;
import com.ecom.demoApplication.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService empService;

	@Autowired
	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployee()
	{
		List<Employee> empList = this.empService.findAll();
		return empList;
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId)
	{
		Employee emp = this.empService.findEmployeeById(employeeId);
		if(emp == null)
		{
			throw new RuntimeException("Employee not found for "+ employeeId);
		}
		return emp;
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		employee.setId(0);
		Employee emp = this.empService.saveEmployee(employee);
		return emp;
	}
	
	
}
