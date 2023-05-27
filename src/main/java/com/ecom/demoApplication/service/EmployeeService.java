package com.ecom.demoApplication.service;

import java.util.List;
import com.ecom.demoApplication.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findEmployeeById(int id);
	public Employee saveEmployee(Employee emp);
	public Employee deleteById(int id);
}
