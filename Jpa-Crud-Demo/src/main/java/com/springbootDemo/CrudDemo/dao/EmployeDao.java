package com.springbootDemo.CrudDemo.dao;

import java.util.List;

import com.springbootDemo.CrudDemo.entity.Employe;

public interface EmployeDao {
	
	public List<Employe> findAll();
	
	public Employe findById(int theId);
	
	public void save(Employe thEmploye);
	
	public void deleteById(int theId);

}
