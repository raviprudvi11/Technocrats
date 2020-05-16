package com.technocrat.Supplier.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.technocrat.Supplier.Bean.Supplier;
import com.technocrat.Supplier.Service.SupplierServiceI;


@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	SupplierServiceI supplierservice;
	
	@RequestMapping(value = "/getSupplierOrderProducts")
	public List<Supplier> getSupplierOrders() {

		return supplierservice.get();
	}

	
	@RequestMapping("/getSupplierPagination")
	@ResponseBody
	public List<Supplier> getProducts(@RequestParam(value="pageStart")int pageStart,@RequestParam(value="pageEnd")int pageEnd){
		
		return supplierservice.get(pageStart,pageEnd);
	}
	
	@RequestMapping(value="/getSupplierOrderById")
	@ResponseBody
	public Supplier getSupplierOrderById(@RequestParam(value="id")int id) {
		return supplierservice.getSupplierOrderById(id);
	}
	

	@RequestMapping(value = "/addSupplierOrder", method = RequestMethod.POST)
	@ResponseBody
	public void addSupplierOrder(@RequestBody Supplier supplier) {
		supplierservice.addSupplierOrder(supplier);
	}



	@RequestMapping(value = "/updateSupplierOrder", method = RequestMethod.POST)
	@ResponseBody
	public void updateSupplierOrder(@RequestBody Supplier supplier) {
		supplierservice.updateSupplierOrder(supplier);
	}

	@RequestMapping(value = "/deleteSupplierOrder", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteSupplierOrder(@RequestParam(value="id") int id) {
		return supplierservice.deleteSupplierOrder(id);
	}

}
