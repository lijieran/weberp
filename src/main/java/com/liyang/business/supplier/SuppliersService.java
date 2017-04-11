package com.liyang.business.supplier;

import com.liyang.business.supplier.entity.Suppliers;


public interface SuppliersService {
	
	public boolean checkSupplierName(String name);
	public boolean checkSupplierId(String id);
	public void saveSupplier(Suppliers entity);
	public String findSuppliers();
	public Suppliers findSupplierById(String id);
	public void deleteSupplierById(String id);
	public void updateSupplier(Suppliers entity);

}
