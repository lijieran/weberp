package com.liyang.business.scheduling.entity;

import com.liyang.business.Entity;


/**
 * 部门实体
 * @author lijieran
 *
 */
public class Department extends Entity{
	
	private int id;
	private String name; 
	private int sort; 
	private String alias; 
	private int parentId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	
	
	
	
	
	
	
	

}
