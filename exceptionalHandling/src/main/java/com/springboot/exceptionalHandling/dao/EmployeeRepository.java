package com.springboot.exceptionalHandling.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.exceptionalHandling.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
