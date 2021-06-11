package com.springbootDemo.CrudDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootDemo.CrudDemo.dao.EmployeDao;
import com.springbootDemo.CrudDemo.entity.Employe;
import com.springbootDemo.CrudDemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeRestController {
	
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeRestController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employe> findAll(){
		
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employe getEmploye(@PathVariable int employeeId) {
		Employe thEmploye=employeeService.findById(employeeId);
		
		if (thEmploye==null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		return thEmploye;
		
	}
	
	@PostMapping("/employees")
	public Employe addEmploye(@RequestBody Employe thEmploye) {
		
		thEmploye.setId(0);
		employeeService.save(thEmploye);
		return thEmploye;
		
		
	}
	
@PutMapping("/employees")
public Employe updateEmployee(@RequestBody Employe thEmploye) {
	
	employeeService.save(thEmploye);
	return thEmploye;
	
}

@DeleteMapping("/employees/{theId}")
public String deleteEmployee(@PathVariable int theId ) {
	
Employe thEmploye=employeeService.findById(theId);

	if(thEmploye==null) {
		
		throw new RuntimeException("employee id not found "+theId);
		
	}
	employeeService.deleteById(theId);
	return "deleted employee id -"+theId;
}
	
	
	
	
	
		
		
	}
	
	
	
	


