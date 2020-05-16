package com.loginManagement.loginSecure.controllers;

import java.util.Arrays;
import java.util.List;

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

import com.loginManagement.loginSecure.ProductManagement.model.StoreProducts;

@CrossOrigin
@RestController("")
public class storeProductManagementController 
{
	@Autowired 
	private RestTemplate restTemplate;
	HttpHeaders headers = new HttpHeaders();
	@RequestMapping(value="/api/storeproducts/getStoreProducts",method = RequestMethod.GET)
	@ResponseBody
	public List<StoreProducts> getStoreProducts()
	{
		String url = "http://localhost:8083/storeproducts/getStoreProducts";
	StoreProducts[] objects= restTemplate.getForObject(url, StoreProducts[].class);
		
		return Arrays.asList(objects);  
	}
	@RequestMapping(value="/api/storeproducts/getStoreProductById/{id}",method = RequestMethod.GET)	
	@ResponseBody
	public StoreProducts getUser(@PathVariable("id") int productId) 
	{
		String url = "http://localhost:8083/storeproducts/getStoreProductbyId?id="+productId;
		StoreProducts objects =restTemplate.getForObject(url, StoreProducts.class);
		System.out.println(objects);
		return objects;
	}
	@RequestMapping(value = "api/storeproducts/addNewStoreProducts", method = RequestMethod.POST)
	@ResponseBody
	public void saveNewProduct(@RequestBody StoreProducts product)
	{
		String url = "http://localhost:8083/storeproducts/addNewStoreProduct";
		System.out.println(product);
		 restTemplate.postForObject(url, product, StoreProducts.class);
	}
	@RequestMapping(value = "api/storeproducts/updateStoreProduct", method = RequestMethod.POST)
	@ResponseBody
	public void updateProduct(@RequestBody StoreProducts product) 
	{
		String url = "http://localhost:8083/storeproducts/updateStoreProduct";
		System.out.println(product);
		HttpEntity<StoreProducts> requestUpdate = new HttpEntity<>(product, headers);
		restTemplate.exchange(url,HttpMethod.POST,requestUpdate,StoreProducts.class);
	}
	@RequestMapping(value = "api/storeproducts/deleteProduct/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable("id") String id) {
		String url = "http://localhost:8083/storeproducts/deleteStoreProduct";
		String entityUrl = url + "?id=" + id;
		restTemplate.delete(entityUrl);
	}
	
}
