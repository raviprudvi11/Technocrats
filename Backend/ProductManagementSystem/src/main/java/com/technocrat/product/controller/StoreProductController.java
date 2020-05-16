package com.technocrat.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.technocrat.product.Bean.StoreProducts;
import com.technocrat.product.service.StoreProductServiceI;

@RestController
@RequestMapping("/storeproducts")
public class StoreProductController {

	@Autowired
	StoreProductServiceI storeproductService;

	@RequestMapping(value = "/getStoreProducts")
	public List<StoreProducts> getProducts() {

		return storeproductService.get();
	}

	@RequestMapping("/getUsersPagination")
	@ResponseBody
	public List<StoreProducts> getStoreProducts(@RequestParam(value = "pageStart") int pageStart,
			@RequestParam(value = "pageEnd") int pageEnd) {
		return storeproductService.get(pageStart, pageEnd);
	}

	@RequestMapping(value = "/getStoreProductbyId" ,method = RequestMethod.GET)
	@ResponseBody
	public StoreProducts getProductsbyId(@RequestParam(value = "id") int id) {

		return storeproductService.getStoreProductById(id);
	}

	@RequestMapping(value = "/addNewStoreProduct", method = RequestMethod.POST)
	@ResponseBody
	public void addNewProduct(@RequestBody StoreProducts storeproducts) {
		storeproductService.addStoreProduct(storeproducts);
	}

	@RequestMapping(value = "/updateStoreProduct", method = RequestMethod.POST)
	@ResponseBody
	public void updateUser(@RequestBody StoreProducts storeproducts) {

		storeproductService.updateStoreProduct(storeproducts);
	}

	@RequestMapping(value = "/deleteStoreProduct", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteUser(@RequestParam(value = "id") int id) {
		return storeproductService.deleteStoreProduct(id);
	}

}
