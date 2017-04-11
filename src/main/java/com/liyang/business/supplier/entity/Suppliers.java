package com.liyang.business.supplier.entity;

/**
 * 供应商
 * @author lijieran
 *
 */
public class Suppliers {
	
	private String id;//编号
	private String name;//供应商名称
	private String address;//公司地址
	private String linkname;//联系人
	private String telephone;//公司电话
	private String mobile;//联系人电话
	private String email;//邮件
	private String mainproduct;//主要产品
	private String companysize;//公司规模:1=少于50人;2=50-150人;3=500-1000人;4=1000人以上
	private String country;//国家
	private String fax;//传真
	private String deleteflag;//删除标记（0：正常；1：删除）
	private String remark;//备注
	private String website;//网站
	private String zipcode;//邮政编码
	private String typeid;//供应商类型编号
	private String termscode;//条款编码
	private String currabrev;//币种
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getLinkname() {
		return linkname;
	}
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMainproduct() {
		return mainproduct;
	}
	public void setMainproduct(String mainproduct) {
		this.mainproduct = mainproduct;
	}
	public String getCompanysize() {
		return companysize;
	}
	public void setCompanysize(String companysize) {
		this.companysize = companysize;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getTermscode() {
		return termscode;
	}
	public void setTermscode(String termscode) {
		this.termscode = termscode;
	}
	public String getCurrabrev() {
		return currabrev;
	}
	public void setCurrabrev(String currabrev) {
		this.currabrev = currabrev;
	}
	
	
}
