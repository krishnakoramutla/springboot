package com.springboot.exceptionalHandling.service;

import java.util.List;

import com.springboot.exceptionalHandling.model.Employee;



public interface EmployeeService  {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public Employee addEmployee(Employee thEmployee);

	public void delete(int theId);

	
}
