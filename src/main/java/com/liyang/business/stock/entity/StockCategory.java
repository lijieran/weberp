package com.liyang.business.stock.entity;

import com.liyang.module.taglib.Option;

/**
 * 物料组
 * @author lijieran
 *
 */
public class StockCategory implements Option{
	
	private String categoryid;
	private String description;
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return description;
	}
	public String getValue() {
		// TODO Auto-generated method stub
		return categoryid;
	}
	
	
	
	

}
