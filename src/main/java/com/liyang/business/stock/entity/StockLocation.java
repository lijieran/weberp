package com.liyang.business.stock.entity;

/**
 * 仓库位置
 * @author lijieran
 *
 */
public class StockLocation {
	
	private String loccode;//仓库编号
	private String name;//仓库名称
	private String address;//仓库地址
	private String telephone;//电话
	private String linkname;//联系人
	public String getLoccode() {
		return loccode;
	}
	public void setLoccode(String loccode) {
		this.loccode = loccode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLinkname() {
		return linkname;
	}
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
	
	

}
