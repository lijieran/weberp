package com.liyang.business.scheduling.entity;

import com.liyang.business.Entity;

/**
 * 岗位实体
 * @author lijieran
 *
 */
public class Post extends Entity{
	
	private int id;
	private String name; // 名称
	private String enabled; // 是否可用，开启/关闭。1表示开启，0表示关闭，默认是关闭
	private int sort; // 排序号
	private Department department;
	
	
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
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

}
