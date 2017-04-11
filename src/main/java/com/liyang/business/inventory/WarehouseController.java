package com.liyang.business.inventory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyang.business.inventory.entity.Warehouse;


@Controller
@RequestMapping("warehouse")
public class WarehouseController {
	
	private static Logger logger = Logger.getLogger(WarehouseController.class);
	
	@Resource
	private InventoryService inventoryService;
	
	@RequestMapping({"index"})
	public String index() {
		return "warehouse/index";
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list( HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String res = inventoryService.findAllWarehouse();
		return res;
	}
	
	@RequestMapping({"add"})
	public String add() {
		return "warehouse/add";
	}
	
	@RequestMapping(value = {"save"})
	public String save(Warehouse entity, Model model) {
		
		 if(entity.getName()==null ) {
			 model.addAttribute("error", "非法请求");
			 return "warehouse/add";
		 }
		
	    return this.saveOrUpdate(entity, model, "add");
	}
	
	@RequestMapping(value = {"update"}, method=RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		
		Warehouse entity = inventoryService.findWarehouseById(id);
		model.addAttribute("entity", entity);
		return "warehouse/update";
	}
	
	@RequestMapping(value = {"update"}, method=RequestMethod.POST)
	public String update(Warehouse entity, Model model) {
		
		 if(entity.getName()==null ) {
			 model.addAttribute("error", "非法请求");
			 return "warehouse/add";
		 }
		
	    return this.saveOrUpdate(entity, model, "update");
	}
	
	private String saveOrUpdate(Warehouse entity, Model model, String type) {
		// TODO Auto-generated method stub
		if(type.equals("add")) inventoryService.saveWarehouse(entity);
		if(type.equals("update")) inventoryService.updateWarehouse(entity);
		return "redirect:"  + "/warehouse/index";
	}
	
	@RequestMapping(value = {"delete"})
	public String delete(HttpServletRequest request, Model model) {
		try {
			String id = request.getParameter("id");
			inventoryService.deleteWarehouseById(id);
		} catch (Exception e) {
			logger.error(e,e);
		}
		return "redirect:"  + "/warehouse/index";
	}
	

}
