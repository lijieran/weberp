package com.liyang.business.scheduling.service;

import com.liyang.business.scheduling.entity.Department;

public interface SchedulingService {
	
	public String findDepartments();
	public void saveDepartment(Department entity);
	public Department findDepartmentById(String id);
	public void updateDepartment(Department entity);

}
