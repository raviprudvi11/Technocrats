package com.technocrats.order.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technocrats.order.beans.Invoice;
@Repository
public interface InventroyDaoI<I> extends JpaRepository<Invoice,Integer> {
	List<Invoice> findAll();
	Invoice saveAndFlush(Invoice invoice);
	Optional<Invoice> findById(Integer id);
	void deleteById(Integer id);
}
