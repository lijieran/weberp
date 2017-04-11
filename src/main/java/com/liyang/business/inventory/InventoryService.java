package com.liyang.business.inventory;

import java.util.List;

import com.liyang.business.inventory.entity.Material;
import com.liyang.business.inventory.entity.Warehouse;

public interface InventoryService {

	void saveWarehouse(Warehouse entity);
	void updateWarehouse(Warehouse entity);
	String findAllWarehouse();
	Warehouse findWarehouseById(String id);
	void deleteWarehouseById(String id);
	List<Warehouse> findWarehouses();
	
	
	void saveMaterial(Material entity);
	void updateMaterial(Material entity);
	String findAllMaterial();
	Material findMaterialById(String id);
	void deleteMaterialById(String id);
	List<Material> findMeaterials();
	
	

}
