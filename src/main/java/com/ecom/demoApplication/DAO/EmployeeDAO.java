package com.ecom.demoApplication.DAO;

import java.util.List;

import com.ecom.demoApplication.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();
	Employee findById(int id);
	Employee addOrUpdate(Employee employee);
	Employee delete(int id);
}
