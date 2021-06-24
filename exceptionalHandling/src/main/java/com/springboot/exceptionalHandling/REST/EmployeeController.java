package com.springboot.exceptionalHandling.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exceptionalHandling.Exception.ApiRequestException;
import com.springboot.exceptionalHandling.model.Employee;
import com.springboot.exceptionalHandling.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public ResponseEntity<List<Employee>> list() {
		List<Employee> tEmployees = employeeService.findAll();
		if (tEmployees.isEmpty()) {
			throw new ApiRequestException("oops list is Empty");
		}

		return new ResponseEntity<List<Employee>>(tEmployees, HttpStatus.FOUND);

	}

	@GetMapping("/list/{id}")
	public ResponseEntity<Employee> empById(@PathVariable("id") int id) {

		Employee tEmployee = employeeService.findById(id);

		return new ResponseEntity<Employee>(tEmployee, HttpStatus.OK);

	}

	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee employeeSaved = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	}

	@PutMapping("/save")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

		Employee employeeSaved = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmploye(@PathVariable("id") int id) {

		employeeService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
