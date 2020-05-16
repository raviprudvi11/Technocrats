package com.technocrat.product.dao;

import java.util.List;

import com.technocrat.product.Bean.StoreProducts;

public interface StoreProductDaoI {

	public List<StoreProducts> get();

	public StoreProducts getStoreProductById(int id);

	void addStoreProduct(StoreProducts storeproducts);

	void updateStoreProduct(StoreProducts storeproducts);

	boolean deleteStoreProduct(int id);

	List<StoreProducts> get(int pagestart, int pageEnd);
	
}
