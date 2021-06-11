package com.springbootDemo.CrudDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootDemo.CrudDemo.dao.EmployeRepository;
import com.springbootDemo.CrudDemo.entity.Employe;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeRepository employeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeRepository employeRepository) {

		this.employeRepository = employeRepository;
	}

	@Override

	public List<Employe> findAll() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

	@Override

	public Employe findById(int theId) {

		Optional<Employe> result = employeRepository.findById(theId);
		Employe employe = null;
		if (result.isPresent()) {
			employe = result.get();
		} else {
			throw new RuntimeException("do not find employe id " + theId);
		}
		return employe;
	}

	@Override

	public void save(Employe thEmploye) {
		employeRepository.save(thEmploye);

	}

	@Override

	public void deleteById(int theId) {
		employeRepository.deleteById(theId);

	}

}
