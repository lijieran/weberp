package com.liyang.business.inventory;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;



import com.liyang.business.AbstractService;
import com.liyang.business.inventory.entity.Material;
import com.liyang.business.inventory.entity.Warehouse;
import com.liyang.business.inventory.mapper.MaterialMapper;
import com.liyang.business.inventory.mapper.WarehouseMapper;

@Service
public class InventoryServiceImpl extends AbstractService implements InventoryService{
	
	private static Logger logger = Logger.getLogger(InventoryServiceImpl.class);
	
	@Resource
	private WarehouseMapper warehouseMapper;
	@Resource
	private MaterialMapper materialMapper;

	public void saveWarehouse(Warehouse entity) {
		// TODO Auto-generated method stub
		try {
			warehouseMapper.save(entity);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public void updateWarehouse(Warehouse entity) {
		// TODO Auto-generated method stub
		try {
			warehouseMapper.update(entity);
		} catch (Exception e) {
			logger.error(e,e);
		}
	}

	public String findAllWarehouse() {
		try {
			List<Warehouse> list = warehouseMapper.findAll();	
			return toJson(list);
		} catch (Exception e) {
			logger.error(e,e);
		}
		return null;
	}

	public Warehouse findWarehouseById(String id) {
		// TODO Auto-generated method stub
		return warehouseMapper.findById(id);
	}

	public void deleteWarehouseById(String id) {
		try {
			warehouseMapper.delete(id);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public List<Warehouse> findWarehouses() {
		// TODO Auto-generated method stub
		return warehouseMapper.findAll();
	}

	public void saveMaterial(Material entity) {
		try {
			materialMapper.save(entity);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public void updateMaterial(Material entity) {
		try {
			materialMapper.update(entity);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public String findAllMaterial() {
		try {
			List<Material> list = materialMapper.findAll();	
			return toJson(list);
		} catch (Exception e) {
			logger.error(e,e);
		}
		return null;
	}

	public Material findMaterialById(String id) {
		// TODO Auto-generated method stub
		return materialMapper.findById(id);
	}

	public void deleteMaterialById(String id) {
		materialMapper.delete(id);
		
	}

	public List<Material> findMeaterials() {
		// TODO Auto-generated method stub
		return materialMapper.findAll();
	}

}
