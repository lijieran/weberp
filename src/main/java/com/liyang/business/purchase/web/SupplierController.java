package com.liyang.business.purchase.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyang.business.purchase.entity.Supplier;
import com.liyang.business.purchase.service.PurchaseService;

@Controller
@RequestMapping("supplier")
public class SupplierController {
	
	private Logger logger = Logger.getLogger(SupplierController.class);
	
	@Resource
	private PurchaseService purchaseService;
	
	@RequestMapping({"index"})
	public String index() {
		return "supplier/index";
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list( HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String res = purchaseService.findSuppliers();
		logger.info(res);
		return res;
	}
	
	@RequestMapping({"add"})
	public String add() {
		return "supplier/add";
	}
	
	@RequestMapping(value = {"update"}, method=RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		
		Supplier entity = purchaseService.findSupplierById(id);
		model.addAttribute("entity", entity);
		return "supplier/update";
	}
	
	@RequestMapping(value = {"delete"})
	public String delete(HttpServletRequest request, Model model) {
		try {
			String id = request.getParameter("id");
			logger.info("供应商删除：" + id);
			purchaseService.deleteSupplierById(id);
		} catch (Exception e) {
			logger.error(e,e);
		}
		return "redirect:"  + "/supplier/index";
	}
	
	@RequestMapping(value = {"save"})
	public String save(Supplier entity, Model model) {
		
		 if(entity.getCompanyName()==null ) {
			 model.addAttribute("error", "非法请求");
			 return "supplier/add";
		 }
		
	    return this.saveOrUpdate(entity, model, "add");
	}
	
	
	
	@RequestMapping(value = {"update"}, method=RequestMethod.POST)
	public String update(Supplier entity, Model model) {
		
		 if(entity.getCompanyName()==null ) {
			 model.addAttribute("error", "非法请求");
			 return "supplier/add";
		 }
		
	    return this.saveOrUpdate(entity, model, "update");
	}
	
	private String saveOrUpdate(Supplier entity, Model model, String type) {
		// TODO Auto-generated method stub
		if(type.equals("add")) purchaseService.saveSupplier(entity);
		if(type.equals("update")) purchaseService.updateSupplier(entity);
		return "redirect:"  + "/supplier/index";
	}

	/**
	 * 验证公司名称是否有效
	 * @param username
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkCompanyName")
	public String checkCompanyName(String companyName) {
		logger.info("公司名称："+companyName);
		if (companyName !=null && purchaseService.checkCompanyName(companyName)) {
			return "false";
		} 
		return "true";
	}

}
