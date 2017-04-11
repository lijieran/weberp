package com.liyang.business.supplier.mapper;

import java.util.List;

import com.liyang.business.supplier.entity.Suppliers;


public interface SuppliersMapper {
	
	Suppliers findByName(String name);
	
	void save(Suppliers entity);
	
	List<Suppliers> findAll();
	
	Suppliers findById(String id);
	
	void delete(String id);
	
	void update(Suppliers entity);

}
