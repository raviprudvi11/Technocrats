package com.technocrat.Supplier.Dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.technocrat.Supplier.Bean.Supplier;


@Repository
public class SupplierDao implements SupplierDaoI{

	@Autowired
	private EntityManager entityManager;
	@Override
	public List<Supplier> get() {
		Session currentsession = entityManager.unwrap(Session.class);
		List<Supplier> supplier = currentsession.createQuery("from Supplier", Supplier.class).getResultList();
		return supplier;
	}

	@Override
	public Supplier getSupplierOrderById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from Supplier where id =:id ";
		Supplier supplier = (Supplier) currentSession.createQuery(hql).setParameter("id", id).getSingleResult();
		return supplier;
	}

	@Override
	public void addSupplierOrder(Supplier supplier) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Serializable i =currentSession.save(supplier);
	}

	@Override
	public void updateSupplierOrder(Supplier supplier) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(supplier);
		
	}

	@Override
	public boolean deleteSupplierOrder(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Supplier supplier= getSupplierOrderById(id);
		if(supplier!=null) {
			currentSession.delete(supplier);
			return true;
		}
		return false;
		
	}
	

	@Override
	public List<Supplier> get(int pageStart, int pageEnd) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from Supplier",Supplier.class);
		query.setFirstResult(pageStart);
        query.setMaxResults(pageEnd);
        List<Supplier> product = query.getResultList();
		return product;
	}

}
