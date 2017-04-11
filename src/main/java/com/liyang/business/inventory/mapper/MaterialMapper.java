package com.liyang.business.inventory.mapper;

import java.util.List;

import com.liyang.business.inventory.entity.Material;

public interface MaterialMapper {
	
	void save(Material entity);
	void update(Material entity);
	void delete(String id);
	Material findByName(String name);
	Material findById(String id);
	List<Material> findAll();

}
