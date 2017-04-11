package com.liyang.business.supplier;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyang.business.supplier.entity.Suppliers;

@Controller
@RequestMapping("suppliers")
public class SuppliersController {
	
	private static Logger logger = Logger.getLogger(SuppliersController.class);
	
	@Resource
	private SuppliersService suppliersService;
	
	@RequestMapping({"index"})
	public String index() {
		return "suppliers/index";
	}
	
	@RequestMapping({"add"})
	public String add() {
		return "suppliers/add";
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list( HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String res = suppliersService.findSuppliers();
		logger.info(res);
		return res;
	}
	
	@RequestMapping(value = {"save"})
	public String save(Suppliers entity, Model model) {
		
		 if(entity.getName()==null ) {
			 model.addAttribute("error", "非法请求");
			 return "suppliers/add";
		 }
		
	    return this.saveOrUpdate(entity, model, "add");
	}
	
	@RequestMapping(value = {"delete"})
	public String delete(HttpServletRequest request, Model model) {
		try {
			String id = request.getParameter("id");
			logger.info("供应商删除：" + id);
			suppliersService.deleteSupplierById(id);
		} catch (Exception e) {
			logger.error(e,e);
		}
		return "redirect:"  + "/suppliers/index";
	}
	
	
	@RequestMapping(value = {"update"}, method=RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		
		Suppliers entity = suppliersService.findSupplierById(id);
		model.addAttribute("entity", entity);
		return "suppliers/update";
	}
	
	
	@RequestMapping(value = {"update"}, method=RequestMethod.POST)
	public String update(Suppliers entity, Model model) {
		
		 if(entity.getName()==null ) {
			 model.addAttribute("error", "非法请求");
			 return "suppliers/add";
		 }
		
	    return this.saveOrUpdate(entity, model, "update");
	}
	
	private String saveOrUpdate(Suppliers entity, Model model, String type) {
		// TODO Auto-generated method stub
		if(type.equals("add")) suppliersService.saveSupplier(entity);
		if(type.equals("update")) suppliersService.updateSupplier(entity);
		return "redirect:"  + "/suppliers/index";
	}
	
	/**
	 * 验证供应商名称是否有效
	 * @param username
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkSupplierName")
	public String checkSupplierName(String name, String source) {
		logger.info("公司名称："+name);
		
		
		if (name !=null && suppliersService.checkSupplierName(name)) {
			return "true";
		} else if(source!=null && source.equals(name)) {
			return "true";
		}
		return "false";
	}
	
	/**
	 * 验证供应商编号是否有效
	 * @param username
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkSupplierId")
	public String checkSupplierId(String id) {
		logger.info("供应商编号："+id);
		if (id !=null && suppliersService.checkSupplierId(id)) {
			return "true";
		} 
		return "false";
	}

}
