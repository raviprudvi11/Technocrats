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

import com.loginManagement.loginSecure.order.bean.Invoice;
@CrossOrigin
@RestController("")
public class orderManagementSystemController
{
	@Autowired 
	private RestTemplate restTemplate;
	HttpHeaders headers = new HttpHeaders();

	@RequestMapping(value="/api/invoice/getAllInvoices",method = RequestMethod.GET)	
	@ResponseBody
	public String getAllInvoices() 
	{
		String url = "http://localhost:8085/invoice/getAllInvoices";
		String objects =restTemplate.getForObject(url, String.class);
		System.out.println(objects);
		return objects;
	}
	
	
	@RequestMapping(value="/api/invoice/updateInvoice",method = RequestMethod.POST)	
	@ResponseBody
	public void updateInvoice(@RequestBody Invoice invoice) 
	{
		String url = "http://localhost:8085/invoice/updateInvoice";
		HttpEntity<Invoice> requestUpdate = new HttpEntity<>(invoice, headers);
		restTemplate.exchange(url,HttpMethod.POST,requestUpdate,Invoice.class);
		
	}
	
	
	
	@RequestMapping(value="/api/invoice/findInvoiceById/{id}",method = RequestMethod.GET)	
	@ResponseBody
	public String findInvoiceById(@PathVariable("id") int userId) 
	{
		String url = "http://localhost:8085/invoice/findInvoiceById?id="+userId;
		String objects =restTemplate.getForObject(url, String.class);
		System.out.println(objects);
		return objects;
	}
	
	
	
	@RequestMapping(value="/api/invoice/createInvoice",method = RequestMethod.POST)	
	@ResponseBody
	public void createInvoice(@RequestBody Invoice invoice) 
	{
		String url = "http://localhost:8085/invoice/createInvoice";
		 restTemplate.postForObject(url, invoice, Invoice.class);

		
	}
	
	
}
