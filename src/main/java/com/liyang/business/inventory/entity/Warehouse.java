package com.liyang.business.inventory.entity;

/**
 * 仓库信息
 * @author lijieran
 *
 */
public class Warehouse {
	
	private int id;
	private String name;//仓库名称
	private String summary;//仓库简价
	private String location;//库位
	private String manager;//负责人
	private String deleteFlag;//删除标志
	
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
	

}
