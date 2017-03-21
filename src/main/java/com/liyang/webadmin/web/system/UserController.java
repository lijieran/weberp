package com.liyang.webadmin.web.system;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyang.module.authc.CheckboxEntity;
import com.liyang.webadmin.entity.User;
import com.liyang.webadmin.service.SystemService;



@Controller
@RequestMapping("user")
public class UserController {
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private SystemService systemService;
	
	
	//@RequiresPermissions("system:user:view")
	@RequestMapping(value = {"index"})
	public String index() {
		logger.info("===========");
		return "system/userIndex";
	}
	
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list( HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String res = systemService.findUsers();
		logger.info(res);
		return res;
	}
	
	
	@RequestMapping(value = {"add"})
	public String userAdd(Model model) {
		List<CheckboxEntity> roles = systemService.findCheckboxRole(null);
		model.addAttribute("roles", roles);
		return "system/userAdd";
	}
	
	@RequestMapping(value = {"update"}, method=RequestMethod.GET)
	public String userUpdate(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		List<CheckboxEntity> roles = systemService.findCheckboxRole(id);
		model.addAttribute("roles", roles);
		
		User entity = systemService.findUserById(id);
		model.addAttribute("entity", entity);
		return "system/userUpdate";
	}
	
	
	
	@RequestMapping(value = {"save"})
	public String save(User entity, Model model) {
		
		 if(entity.getName()==null || entity.getPassword()==null) {
			 model.addAttribute("error", "非法请求");
			 return "system/userAdd";
		 }
		
	    return this.saveOrUpdate(entity, model, "add");
	}
	

	@RequestMapping(value = {"update"}, method=RequestMethod.POST)
	public String update(User entity, Model model) {
		
	    return this.saveOrUpdate(entity, model, "update");
	}
	
	private String saveOrUpdate(User entity, Model model,String type) {
		try {
			if(type.equals("update") && entity.getId()==null) {
				model.addAttribute("error", "用户非法请求");
				logger.info("用户添加非法请求");
				if(type.equals("add")) return "system/userAdd";
				if(type.equals("update")) return "system/userUpdate";
			}
			
			
	
			logger.info("角色信息：" + entity.getName() );
			
			if(type.equals("add")) systemService.saveUser(entity);
			if(type.equals("update")) systemService.updateUser(entity);
		   
		} catch (Exception e) {
			logger.error(e,e);
		}
		return "redirect:"  + "/user/index";
	}
	
	/**
	 * 验证登录名是否有效
	 * @param oldLoginName
	 * @param loginName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkLoginName")
	public String checkLoginName(String username) {
		logger.info("用户名："+username);
		if (username !=null && !systemService.checkLoginName(username)) {
			return "false";
		} 
		return "true";
	}
	
	@RequestMapping(value = {"delete"})
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		logger.info("用户删除===="+id);
		systemService.deleteUser(id);
		return "redirect:"  + "/user/index";
	}

	
	

}
