package com.technocrat.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.technocrat.product.Bean.StoreProducts;
import com.technocrat.product.dao.StoreProductDaoI;

@Service
public class StoreProductService implements StoreProductServiceI {

	@Autowired
	StoreProductDaoI storeproductDao;

	@Transactional
	public List<StoreProducts> get() {
		return storeproductDao.get();
	}

	@Transactional
	public StoreProducts getStoreProductById(int id) {
		return storeproductDao.getStoreProductById(id);
	}

	@Transactional
	public void addStoreProduct(StoreProducts storeproducts) {
		storeproductDao.addStoreProduct(storeproducts);
	}

	@Transactional
	
	public void updateStoreProduct(StoreProducts storeproducts) {
		storeproductDao.updateStoreProduct(storeproducts);
	}

	@Transactional
	
	public boolean deleteStoreProduct(int id) {
		return storeproductDao.deleteStoreProduct(id);

	}

	public List<StoreProducts> get(int pageStart, int pageEnd) {
		// TODO Auto-generated method stub
		return storeproductDao.get(pageStart, pageEnd);
	}

	
}
