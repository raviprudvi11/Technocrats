package com.loginManagement.loginSecure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import SupplierManagementSystem.models.Supplier;


@CrossOrigin
@RestController("")
public class SupplierManagementSystemController
{
	@Autowired 
	private RestTemplate restTemplate;
	HttpHeaders headers = new HttpHeaders();
	@RequestMapping(value="/api/supplier/getSupplierOrders",method = RequestMethod.GET)	
	@ResponseBody
	public String getSupplierOrders() 
	{
		String url = "http://localhost:8086/supplier/getSupplierOrders";
		String objects =restTemplate.getForObject(url, String.class);
		System.out.println(objects);
		return objects;
	}
	@RequestMapping(value="/api/supplier/getSupplierOrderById/{id}",method = RequestMethod.GET)	
	@ResponseBody
	public String getSupplierOrderById(@PathVariable("id") int userId) 
	{
		String url = "http://localhost:8086/supplier/getSupplierOrders?id="+userId;
		String objects =restTemplate.getForObject(url, String.class);
		System.out.println(objects);
		return objects;
	}

	@RequestMapping(value="/api/supplier/addSupplierOrder",method = RequestMethod.POST)	
	@ResponseBody
	public void addSupplierOrder(@RequestBody Supplier supplier) 
	{
		String url = "http://localhost:8086/supplier/addSupplierOrder";
		 restTemplate.postForObject(url, supplier, Supplier.class);

		
	}
	
	@RequestMapping(value="/api/supplier/updateSupplierOrder",method = RequestMethod.POST)	
	@ResponseBody
	public void updateSupplierOrder(@RequestBody Supplier supplier) 
	{
		String url = "http://localhost:8086/supplier/updateSupplierOrder";
		HttpEntity<Supplier> requestUpdate = new HttpEntity<>(supplier, headers);
		restTemplate.exchange(url,HttpMethod.POST,requestUpdate,Supplier.class);
		
	}
	@RequestMapping(value="/api/supplier/deleteSupplierOrder/{id}",method = RequestMethod.GET)	
	@ResponseBody
	public void deleteSupplierOrder(@PathVariable("id") int userId) 
	{
		String url = "http://localhost:8086/supplier/deleteSupplierOrder?id="+userId;
		restTemplate.delete(url);
		
	}

	

}
