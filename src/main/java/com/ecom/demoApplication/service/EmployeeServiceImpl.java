package com.ecom.demoApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.demoApplication.DAO.EmployeeDAO;
import com.ecom.demoApplication.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	public List<Employee> findAll() {
		List<Employee> empList = this.employeeDAO.findAll();
		return empList;
	}

	@Override
	public Employee findEmployeeById(int id) {
		Employee emp = this.employeeDAO.findById(id);
		return emp;
	}

	@Override
	@Transactional
	public Employee saveEmployee(Employee emp) {
		Employee employee = this.employeeDAO.addOrUpdate(emp);
		return employee;
	}

	@Override
	@Transactional
	public Employee deleteById(int id) {
		Employee emp = this.employeeDAO.delete(id);
		return emp;
	}

}
