package com.technocrats.order.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.aspectj.weaver.Dump.INode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.technocrats.order.beans.Bill;
import com.technocrats.order.beans.Invoice;
import com.technocrats.order.beans.Location;
import com.technocrats.order.beans.Sales;
import com.technocrats.order.beans.User;
import com.technocrats.order.dao.InventroyDaoI;
import com.technocrats.order.dao.SalesDaoI;

@Service
public class InvoiceService {
	@Autowired
	InventroyDaoI<Invoice> invoiceRepository;

	@Autowired
	SalesService salesService;
	
	@Transactional
	public List<Invoice> getAllInvoice() throws Exception{
		return invoiceRepository.findAll();
	}
	
	@Transactional
	public Bill createInvoice(Invoice invoice) throws Exception {
		Set<Sales> sales=invoice.getSalesList();
		invoice.setSalesList(null);
		System.out.println(invoice);
		Invoice in =save(invoice);
	//	invoiceRepository.flush();
		System.out.println(in.getId());
		for(Sales s : sales) {
			s.setInvoiceId(in.getId());
			salesService.saveSales(s);
		}
		User user=getUserDetails(in.getUserid());
		Location location = getLocation(user.getLocationId());
		return generateBill(user,invoice,location);
		
	}
	public Bill generateBill(User user,Invoice invoice,Location location) {
		Bill bill = new Bill();
		bill.setInvoiceID(invoice.getId());
		bill.setStoreAddress(location.getAddress());
		bill.setStoreName(location.getBrandname());
		bill.setProducts((invoice.getSalesList()));
		bill.setTotalAmount(invoice.getTotalprice());
		bill.setNumberOfProducts(invoice.getSalesList().size());
		bill.setStoreAddress(location.getAddress());
		return bill;
	}
	public Location getLocation(int locationID) {
		final String uri = "http://localhost:8084/store/getStore?storeId="+locationID;
	     
	    RestTemplate restTemplate = new RestTemplate();
	    Location result = restTemplate.getForObject(uri, Location.class);
	     
	    System.out.println(result);
	    return result;
	}
	public User getUserDetails(int userId) {
		final String uri = "http://localhost:8081/users/getUser?id="+userId;
	     
	    RestTemplate restTemplate = new RestTemplate();
	    User result = restTemplate.getForObject(uri, User.class);
	     
	    System.out.println(result);
	    return result;
	}
	
	@Transactional
	public Invoice save(Invoice invoice) throws Exception  {
		
		Invoice in =invoiceRepository.save(invoice);//saveAndFlush(invoice);
		invoiceRepository.flush();
		return in;
	}
	
	@Transactional
	void deleteById(int id) throws Exception  {
		invoiceRepository.deleteById(id);
	}
	
	@Transactional
	public Optional<Invoice> getInvoiceById(int id) throws Exception  {
		return invoiceRepository.findById(id);
	}
	
	@Transactional
	public Invoice update(Invoice invoice) throws Exception  {
		return invoiceRepository.save(invoice);
	}
	
}
