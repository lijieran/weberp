package com.liyang.business.purchase.service;

import com.liyang.business.purchase.entity.Supplier;

public interface PurchaseService {
	
	public boolean checkCompanyName(String companyName);
	public void saveSupplier(Supplier entity);
	public String findSuppliers();
	public Supplier findSupplierById(String id);
	public void deleteSupplierById(String id);
	public void updateSupplier(Supplier entity);

}
