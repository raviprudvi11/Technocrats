package com.technocrat.Supplier.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technocrat.Supplier.Bean.Supplier;
import com.technocrat.Supplier.Dao.SupplierDaoI;

@Service
public class SupplierService implements SupplierServiceI{

	@Autowired
	SupplierDaoI supplierDao;

	@Transactional

	public List<Supplier> get() {
		// TODO Auto-generated method stub
		 
		return supplierDao.get();
	}

	@Transactional

	public Supplier getSupplierOrderById(int id) {
		// TODO Auto-generated method stub
		return supplierDao.getSupplierOrderById(id);
	}

	@Transactional

	public void addSupplierOrder(Supplier supplier) {
		// TODO Auto-generated method stub\
		supplierDao.addSupplierOrder(supplier);
		
	}

	@Transactional

	public void updateSupplierOrder(Supplier supplier) {
		// TODO Auto-generated method stub
		supplierDao.updateSupplierOrder(supplier);
	}

	@Transactional

	public boolean deleteSupplierOrder(int id) {
		// TODO Auto-generated method stub
		return supplierDao.deleteSupplierOrder(id);
	}

	@Transactional

	public List<Supplier> get(int pagestart, int pageEnd) {
		// TODO Auto-generated method stub
		return supplierDao.get(pagestart, pageEnd);
	}



}
