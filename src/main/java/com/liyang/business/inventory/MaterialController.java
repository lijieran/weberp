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

import com.liyang.business.inventory.entity.Material;


@Controller
@RequestMapping("material")
public class MaterialController {
	
	private static Logger logger = Logger.getLogger(MaterialController.class);
	
	@Resource
	private InventoryService inventoryService;
	
	@RequestMapping({"index"})
	public String index() {
		return "material/index";
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list( HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String res = inventoryService.findAllMaterial();
		return res;
	}
	
	@RequestMapping({"add"})
	public String add() {
		return "material/add";
	}
	
	@RequestMapping(value = {"save"})
	public String save(Material
			entity, Model model) {
		
		 if(entity.getName()==null ) {
			 model.addAttribute("error", "非法请求");
			 return "material/add";
		 }
		
	    return this.saveOrUpdate(entity, model, "add");
	}
	
	@RequestMapping(value = {"update"}, method=RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		
		Material entity = inventoryService.findMaterialById(id);
		model.addAttribute("entity", entity);
		return "material/update";
	}
	
	@RequestMapping(value = {"update"}, method=RequestMethod.POST)
	public String update(Material entity, Model model) {
		
		 if(entity.getName()==null ) {
			 model.addAttribute("error", "非法请求");
			 return "material/add";
		 }
		
	    return this.saveOrUpdate(entity, model, "update");
	}
	
	private String saveOrUpdate(Material entity, Model model, String type) {
		// TODO Auto-generated method stub
		if(type.equals("add")) inventoryService.saveMaterial(entity);
		if(type.equals("update")) inventoryService.updateMaterial(entity);
		return "redirect:"  + "/material/index";
	}
	
	@RequestMapping(value = {"delete"})
	public String delete(HttpServletRequest request, Model model) {
		try {
			String id = request.getParameter("id");
			inventoryService.deleteMaterialById(id);
		} catch (Exception e) {
			logger.error(e,e);
		}
		return "redirect:"  + "/material/index";
	}
	

}
