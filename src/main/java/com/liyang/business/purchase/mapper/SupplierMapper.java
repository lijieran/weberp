package com.liyang.business.purchase.mapper;

import java.util.List;

import com.liyang.business.purchase.entity.Supplier;

public interface SupplierMapper {
	
	Supplier findByCompanyName(String companyName);
	
	void save(Supplier entity);
	
	List<Supplier> findAll();
	
	Supplier findById(String id);
	
	void delete(String id);
	
	void update(Supplier entity);

}
