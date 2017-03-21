package com.liyang.business.scheduling.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.liyang.business.scheduling.entity.Department;
import com.liyang.business.scheduling.mapper.DepartmentMapper;

@Service
public class SchedulingServiceImpl implements SchedulingService {

	private static Logger logger = Logger.getLogger(SchedulingServiceImpl.class);

	@Resource
	private DepartmentMapper departmentMapper;

	public String findDepartments() {
		try {

			List<Department> list = departmentMapper.findAll();
			Gson gson = new Gson();
			String json = gson.toJson(list);
			return json;
		} catch (Exception e) {
			logger.error(e, e);
		}
		return null;
	}

	public void saveDepartment(Department entity) {
		try {
			departmentMapper.save(entity);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public Department findDepartmentById(String id) {
		try {
			return departmentMapper.findById(id);
		} catch (Exception e) {
			logger.error(e,e);
		}
		return null;
	}

	public void updateDepartment(Department entity) {
		try {
			departmentMapper.update(entity);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

}
