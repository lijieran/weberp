package com.liyang.webadmin.persistence.mapper;

import java.util.List;

import com.liyang.module.config.entity.Meta;

public interface MetaMapper {
	
	List<Meta> findAll();
	
	List<Meta> findByType(String type);

}
