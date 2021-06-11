package com.springbootDemo.CrudDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootDemo.CrudDemo.dao.EmployeDao;
import com.springbootDemo.CrudDemo.entity.Employe;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeDao employeDao;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeDaoImplJpa")
			
			
			EmployeDao employeDao) {
		
		this.employeDao = employeDao;
	}

	@Override
	@Transactional
	public List<Employe> findAll() {
		// TODO Auto-generated method stub
		return employeDao.findAll();
	}

	@Override
	@Transactional
	public Employe findById(int theId) {
		// TODO Auto-generated method stub
		return employeDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employe thEmploye) {
	employeDao.save(thEmploye);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeDao.deleteById(theId);

	}

}
