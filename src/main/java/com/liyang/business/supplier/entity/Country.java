package com.liyang.business.supplier.entity;

import com.liyang.module.taglib.Option;


/**
 * 国家
 * @author lijieran
 *
 */
public class Country implements Option{
	private String abbrev;
	private String cnname;
	private String enname;
	public String getAbbrev() {
		return abbrev;
	}
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
	public String getCnname() {
		return cnname;
	}
	public void setCnname(String cnname) {
		this.cnname = cnname;
	}
	public String getEnname() {
		return enname;
	}
	public void setEnname(String enname) {
		this.enname = enname;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return cnname;
	}
	public String getValue() {
		// TODO Auto-generated method stub
		return cnname;
	}
	
	
	
	
	

}
