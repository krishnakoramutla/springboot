package com.springbootEmp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootEmp.main.dao.EmployeRepository;
import com.springbootEmp.main.entity.Employe;

@Service
public class EmployeServiceImpl implements EmployeService {

	private EmployeRepository employeRepository;

	@Autowired
	public EmployeServiceImpl(EmployeRepository employeRepository) {

		this.employeRepository = employeRepository;
	}

	@Override
	public List<Employe> findAll() {

		return employeRepository.findAll();
	}

	@Override
	public Employe findById(int id) {
		

	return employeRepository.getById(id);
	}

	@Override
	public void save(Employe thEmploye) {
	employeRepository.save(thEmploye);

	}

	@Override
	public void deleteById(int id) {
		employeRepository.deleteById(id);

	}

}
