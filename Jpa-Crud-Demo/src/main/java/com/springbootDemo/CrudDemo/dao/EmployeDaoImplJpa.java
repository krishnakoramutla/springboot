package com.springbootDemo.CrudDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootDemo.CrudDemo.entity.Employe;

@Repository
public class EmployeDaoImplJpa implements EmployeDao{

	private EntityManager entityManager;
	
	@Autowired
	public EmployeDaoImplJpa(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}

	@Override
	public List<Employe> findAll() {
		Query theQuery=entityManager.createQuery("from Employe");
		List<Employe> employes=theQuery.getResultList();
	
		return employes;
	}

	@Override
	public Employe findById(int theId) {
Employe thEmploye=entityManager.find(Employe.class, theId);

		return thEmploye;
	}

	@Override
	public void save(Employe thEmploye) {
		Employe dbEmploye=entityManager.merge(thEmploye);
		thEmploye.setId(dbEmploye.getId());
	}

	@Override
	public void deleteById(int theId) {
Query theQuery=entityManager.createQuery("delete from Employe where id=:employeId");
theQuery.setParameter("employeId", theId);
theQuery.executeUpdate();
		
	}

}
