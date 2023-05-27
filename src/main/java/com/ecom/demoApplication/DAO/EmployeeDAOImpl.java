package com.ecom.demoApplication.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecom.demoApplication.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	private EntityManager entityManager;
	
	public EmployeeDAOImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> theQuery = this.entityManager.createQuery("from Employee", Employee.class);
		List<Employee> employeeList =theQuery.getResultList();
		
		return employeeList;
	}

	@Override
	public Employee findById(int id) {
		Employee employee = this.entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public Employee addOrUpdate(Employee employee) {
		Employee emp = this.entityManager.merge(employee);
		return emp;
	}

	@Override
	public Employee delete(int id) {
		// TODO Auto-generated method stub
		Employee emp = this.entityManager.find(Employee.class, id);
		
		this.entityManager.remove(emp);
		return null;
	}

}
