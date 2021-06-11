package com.springbootDemo.CrudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootDemo.CrudDemo.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
