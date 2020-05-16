package com.technocrat.Supplier.Service;

import java.util.List;

import com.technocrat.Supplier.Bean.Supplier;


public interface SupplierServiceI {

	public List<Supplier> get();

	public Supplier getSupplierOrderById(int id);

	void addSupplierOrder(Supplier supplier);

	void updateSupplierOrder(Supplier supplier);

	boolean deleteSupplierOrder(int id);

	List<Supplier> get(int pagestart, int pageEnd);
}
