package com.liyang.business.stock.entity;

/**
 * 仓库物料
 * @author lijieran
 *
 */
public class StockItem {
	
	private String stockid;
	private String description;
	private String categoryid;
	private int eoq;
	private String units;
	public String getStockid() {
		return stockid;
	}
	public void setStockid(String stockid) {
		this.stockid = stockid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public int getEoq() {
		return eoq;
	}
	public void setEoq(int eoq) {
		this.eoq = eoq;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	
	

}
