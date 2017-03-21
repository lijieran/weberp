package com.liyang.business.scheduling.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyang.business.scheduling.entity.Department;
import com.liyang.business.scheduling.service.SchedulingService;

@Controller
@RequestMapping("scheduling")
public class SchedulingController {
	
	@Resource
	private SchedulingService schedulingService;
	
	@RequestMapping({"index"})
	public String index() {
		return "scheduling/index";
	}
	
	@RequestMapping({"department"})
	public String department() {
		
		return "scheduling/department";
	}
	
	
	@ResponseBody
	@RequestMapping({"departmentList"})
	public String departmentList() {
		
		return schedulingService.findDepartments();
	}
	
	@RequestMapping({"departmentAdd"})
	public String departmentAdd(HttpServletRequest request, Department entity) {
		
		String method = request.getMethod();
		if("GET".equals(method)) return "scheduling/departmentAdd";
		
		if(entity==null || entity.getName()==null) {
			return "scheduling/departmentAdd";
		}
		
		schedulingService.saveDepartment(entity);
		
		return "redirect:department";
	}
	
	@RequestMapping({"departmentUpdate"})
	public String departmentUpdate(HttpServletRequest request, Department entity, Model model) {
		
		String method = request.getMethod();
		String id = request.getParameter("id");
		
		
		
		if("GET".equals(method)) {
			Department tmp =  schedulingService.findDepartmentById(id);
			model.addAttribute("entity", tmp);
			return "scheduling/departmentUpdate";
		}
		
		if(entity==null || entity.getName()==null) {
			return "redirect:department";
		}
		
		schedulingService.updateDepartment(entity);
		
		return "redirect:department";
	}
	

}
