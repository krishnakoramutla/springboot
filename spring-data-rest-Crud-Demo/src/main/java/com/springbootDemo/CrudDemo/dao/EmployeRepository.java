package com.springbootDemo.CrudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springbootDemo.CrudDemo.entity.Employe;

@RepositoryRestResource(path = "members")
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
