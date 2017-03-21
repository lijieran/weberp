package com.liyang.webadmin.web;


import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DefaultController {
	
	private String adminPath = "home";
	
	@RequestMapping("login")
	public String login() {
		System.out.println("=====");
		
		Subject subject = SecurityUtils.getSubject();
		Object principal = (Object) subject.getPrincipal();

		// 如果已经登录，则跳转到管理首页
		if (principal != null) {
			return "redirect:" + adminPath;
		}
		subject.logout();
		return "system/login";
	}
	
	@RequestMapping("logout")
	public String logout() {
		
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "system/login";
	}
	
	@RequestMapping("success")
	public String success() {
		System.out.println("=====");
		return "system/success";
	}

	@RequestMapping({"home",""})
	public String home(HttpServletRequest request) {
		System.out.println("=====");
		        
        
		return "system/home";
	}
	
}
