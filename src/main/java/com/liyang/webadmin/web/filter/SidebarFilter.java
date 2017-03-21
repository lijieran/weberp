package com.liyang.webadmin.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.filter.GenericFilterBean;

import com.liyang.module.spring.SpringContextHolder;
import com.liyang.webadmin.web.sidebar.SidebarFactory;

public class SidebarFilter extends GenericFilterBean{
	
	private static Logger logger = Logger.getLogger(SidebarFilter.class);

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest re = (HttpServletRequest) request;
		SidebarFactory sidebarFactory = SpringContextHolder.getBean(SidebarFactory.class);
		String root = re.getContextPath();
		String uri = re.getRequestURI();
		uri = uri.replace(root, "");
		
		logger.info("请求的URI=" + uri);
		
		//logger.info(root);
		
		String sidebar = sidebarFactory.generateSidebar(uri);
		
		
		sidebar = sidebar.replace("##ROOT##", root);
		//logger.info(sidebar);
		request.setAttribute("sidebar", sidebar);
		
		
		Subject subject = SecurityUtils.getSubject();
		Object principal = (Object) subject.getPrincipal();

		// 如果已经登录，则跳转到管理首页
		if (principal != null) {
			System.out.println(principal);
			request.setAttribute("username", principal);
			
		}
		
		chain.doFilter(request, response);
		
	}

}
