package com.liyang.business.supplier.entity;

import com.liyang.module.taglib.Option;

/**
 * 供应商货币
 * @author lijieran
 *
 */
public class Currencies implements Option{
	
	private String currabrev; //币种
	private String currency;//货币名称
	private String country;//国家
	private double rate; //汇率
	public String getCurrabrev() {
		return currabrev;
	}
	public void setCurrabrev(String currabrev) {
		this.currabrev = currabrev;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return currency;
	}
	public String getValue() {
		// TODO Auto-generated method stub
		return currabrev;
	}
	
	

}
