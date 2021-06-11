package com.springbootDemo.CrudDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootDemo.CrudDemo.entity.Employe;

@Repository
public class EmployeDaoHibernateImpl implements EmployeDao {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeDaoHibernateImpl(EntityManager entityManager) {
	
		this.entityManager = entityManager;
	}



	@Override
	
	public List<Employe> findAll() {
		
		Session session=entityManager.unwrap(Session.class);
		
		Query<Employe> theQuery=session.createQuery("from Employe",Employe.class);
		List<Employe> employes=theQuery.getResultList();
		
		
		return employes;
	}



	@Override
	public Employe findById(int theId) {
		Session session=entityManager.unwrap(Session.class);
		Employe thEmploye=session.get(Employe.class, theId);
		
		return thEmploye;
	}



	@Override
	public void save(Employe thEmploye) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(thEmploye);
	}



	@Override
	public void deleteById(int theId) {
		Session session=entityManager.unwrap(Session.class);
		Query tHEQuery=session.createQuery("delete from Employe where id=:employeeId");
		tHEQuery.setParameter("employeeId", theId);
		tHEQuery.executeUpdate();
	}

}
