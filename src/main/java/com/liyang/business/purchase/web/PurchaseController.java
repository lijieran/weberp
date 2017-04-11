package com.liyang.business.purchase.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liyang.business.inventory.InventoryService;
import com.liyang.business.inventory.entity.Warehouse;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	
	@Resource
	private InventoryService inventoryService;
	
	@RequestMapping({"index"})
	public String index(Model model) {
		
		List<Warehouse> warehouses = inventoryService.findWarehouses();
		model.addAttribute("warehouses", warehouses);
		return "purchase/index";
	}

}
