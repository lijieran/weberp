package com.liyang.business.supplier.entity;

import com.liyang.module.taglib.Option;


/**
 * 供应商类型
 * @author lijieran
 *
 */
public class SupplierType implements Option{
	
	private String typeid;//类型编号
	private String typename;//类型名称
	
	
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getName() {
		return typename;
	}
	public String getValue() {
		return typeid;
	}
	
	

}
