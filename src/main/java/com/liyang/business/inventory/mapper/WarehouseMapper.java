package com.liyang.business.inventory.mapper;

import java.util.List;

import com.liyang.business.inventory.entity.Warehouse;

public interface WarehouseMapper {
	
	void save(Warehouse entity);
	void update(Warehouse entity);
	void delete(String id);
	Warehouse findByName(String name);
	Warehouse findById(String id);
	List<Warehouse> findAll();

}
