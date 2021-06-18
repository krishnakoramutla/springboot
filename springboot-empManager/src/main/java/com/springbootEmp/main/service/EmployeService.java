package com.springbootEmp.main.service;

import java.util.List;

import com.springbootEmp.main.entity.Employe;

public interface EmployeService {
	
	public List<Employe> findAll();
	public Employe findById(int id);
	public void save(Employe thEmploye);
	public void deleteById(int id);

}
