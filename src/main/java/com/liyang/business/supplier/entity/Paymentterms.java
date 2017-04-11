package com.liyang.business.supplier.entity;

import com.liyang.module.taglib.Option;

/**
 * 付款条款
 * @author lijieran
 *
 */
public class Paymentterms implements Option{
	
	private String termscode;//条款编码
	private String terms;//付款条款描述
	private int daysbeforedue;//到期天数
	private int dayinfollowingmonth;//下个月的某个日期
	public String getTermscode() {
		return termscode;
	}
	public void setTermscode(String termscode) {
		this.termscode = termscode;
	}
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public int getDaysbeforedue() {
		return daysbeforedue;
	}
	public void setDaysbeforedue(int daysbeforedue) {
		this.daysbeforedue = daysbeforedue;
	}
	public int getDayinfollowingmonth() {
		return dayinfollowingmonth;
	}
	public void setDayinfollowingmonth(int dayinfollowingmonth) {
		this.dayinfollowingmonth = dayinfollowingmonth;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return terms;
	}
	public String getValue() {
		// TODO Auto-generated method stub
		return termscode;
	}
	
	

}
