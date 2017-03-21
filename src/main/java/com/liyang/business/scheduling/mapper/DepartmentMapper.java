package com.liyang.business.scheduling.mapper;

import java.util.List;

import com.liyang.business.scheduling.entity.Department;

public interface DepartmentMapper {
	
	List<Department> findAll();
	
	void save(Department entity);
	
	Department findById(String id);
	
	void update(Department entity);

}
