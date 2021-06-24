package com.springboot.exceptionalHandling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exceptionalHandling.dao.EmployeeRepository;
import com.springboot.exceptionalHandling.model.Employee;


@Service
public class EmployeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeServiceImpl(EmployeeRepository employeeRepository) {

		this.employeeRepository = employeeRepository;
	}

	
	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result=employeeRepository.findById(id);
		
		Employee thEmployee=result.get();
		return thEmployee;
	}

	

	@Override
	public void delete(int theId) {
			employeeRepository.deleteById(theId);
	

	}


	@Override
	public Employee addEmployee(Employee thEmployee) {
		Employee savedEmployee=employeeRepository.save(thEmployee);
		return savedEmployee;
	}

}
