package com.springbootEmp.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootEmp.main.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
