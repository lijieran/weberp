package com.liyang.business.purchase.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


import com.liyang.business.AbstractService;
import com.liyang.business.purchase.entity.Supplier;
import com.liyang.business.purchase.mapper.SupplierMapper;

@Service
public class PurchaseServiceImpl extends AbstractService implements PurchaseService{
	
	private static Logger logger = Logger.getLogger(PurchaseServiceImpl.class);
	
	@Resource
	private SupplierMapper supplierMapper;

	public boolean checkCompanyName(String companyName) {
		// TODO Auto-generated method stub
		Supplier entity = supplierMapper.findByCompanyName(companyName);
		if(entity!=null) return true;
		return false;
	}

	public void saveSupplier(Supplier entity) {
		// TODO Auto-generated method stub
		try {
			supplierMapper.save(entity);
		} catch (Exception e) {
			logger.error(e,e);
		}
	}

	
	public String findSuppliers() {
		// TODO Auto-generated method stub
		List<Supplier> list = supplierMapper.findAll();
		
		return toJson(list);
	}

	public Supplier findSupplierById(String id) {
		// TODO Auto-generated method stub
		return supplierMapper.findById(id);
	}

	public void deleteSupplierById(String id) {
		try {
			supplierMapper.delete(id);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public void updateSupplier(Supplier entity) {
		try {
			supplierMapper.update(entity);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

}
