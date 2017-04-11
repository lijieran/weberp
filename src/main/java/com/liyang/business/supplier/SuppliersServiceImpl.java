package com.liyang.business.supplier;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.liyang.business.AbstractService;
import com.liyang.business.supplier.entity.Suppliers;
import com.liyang.business.supplier.mapper.SuppliersMapper;


@Service
public class SuppliersServiceImpl extends AbstractService implements SuppliersService{
	
	private static Logger logger = Logger.getLogger(SuppliersServiceImpl.class);
	
	@Resource
	private SuppliersMapper suppliersMapper;

	public boolean checkSupplierName(String name) {
		try {
			if(suppliersMapper.findByName(name)==null) return true;
		} catch (Exception e) {
			logger.error(e,e);
		}
		return false;
	}

	public void saveSupplier(Suppliers entity) {
		try {
			suppliersMapper.save(entity);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public String findSuppliers() {
		try {
			List<Suppliers> list = suppliersMapper.findAll();
			
			return toJson(list);
		} catch (Exception e) {
			logger.error(e,e);
		}
		return "";
	}

	public Suppliers findSupplierById(String id) {
		// TODO Auto-generated method stub
		return suppliersMapper.findById(id);
	}

	public void deleteSupplierById(String id) {
		try {
			suppliersMapper.delete(id);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public void updateSupplier(Suppliers entity) {
		try {
			suppliersMapper.update(entity);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public boolean checkSupplierId(String id) {
		// TODO Auto-generated method stub
		try {
			if(this.findSupplierById(id)==null) return true;
		} catch (Exception e) {
			logger.error(e,e);
		}
		return false;
	}

}
