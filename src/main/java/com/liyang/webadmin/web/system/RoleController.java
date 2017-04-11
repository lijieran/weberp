package com.liyang.webadmin.web.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyang.webadmin.entity.Role;
import com.liyang.webadmin.service.AuthenticationService;
import com.liyang.webadmin.service.SystemService;
import com.liyang.webadmin.web.MetaUtils;

@Controller
@RequestMapping("role")
public class RoleController {
	
	
	private static Logger logger = Logger.getLogger(RoleController.class);

	@Resource
	private SystemService systemService;
	
	@Resource
	private AuthenticationService authenticationService;
	
	@RequestMapping(value = {"index"})
	public String index(Model model) {
		logger.info("===========");
		String useableMeta = MetaUtils.generateColumnDefs("useable");
		model.addAttribute("useableMeta", useableMeta);
		return "system/roleIndex";
	}
	
	@RequestMapping(value = {"add"})
	public String roleAdd(Model model) {
		
		model.addAttribute("treelist", authenticationService.ztreeMenu());
		return "system/roleAdd";
	}
	
	@RequestMapping(value = {"update"}, method=RequestMethod.GET)
	public String roleUpdate(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		model.addAttribute("treelist", authenticationService.ztreeMenu(id));
		
		Role entity = systemService.findRoleById(id);
		model.addAttribute("entity", entity);
		return "system/roleUpdate";
	}
	
	@ResponseBody
	@RequestMapping(value = {"list"})
	public String list( HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("查找角色列表====");
		String res = systemService.findRoles();
		return res;
	}
	
	@RequestMapping(value = {"save"})
	public String save(Role entity, Model model, HttpServletRequest request) {
	   
		return this.saveOrUpdate(entity, model, request, "add");
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Role entity, Model model, HttpServletRequest request) {
		
		return this.saveOrUpdate(entity, model, request, "update");
	}
	
	@RequestMapping(value = {"delete"})
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		logger.info("角色删除===="+id);
		systemService.deleteRole(id);
		return "redirect:"  + "/role/index";
	}
	
	private String saveOrUpdate(Role entity, Model model, HttpServletRequest request, String type) {
		try {
			if( entity.getName()==null) {
				model.addAttribute("error", "非法请求");
				logger.info("角色添加非法请求");
				if(type.equals("add")) return "system/saveAdd";
				if(type.equals("update")) return "system/saveUpdate";
			}
			
			
	
			logger.info("角色信息：" + entity.getName() );
			
			if(type.equals("add")) systemService.saveRole(entity);
			if(type.equals("update")) systemService.updateRole(entity);
		   
		} catch (Exception e) {
			logger.error(e,e);
		}
		return "redirect:"  + "/role/index";
	}
	
	

}
