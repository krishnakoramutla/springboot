package com.springbootDemo.CrudDemo.service;

import java.util.List;

import com.springbootDemo.CrudDemo.entity.Employe;

public interface EmployeeService {
	
public List<Employe> findAll();
	
	public Employe findById(int theId);
	
	public void save(Employe thEmploye);
	
	public void deleteById(int theId);


}
