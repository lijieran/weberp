package com.liyang;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liyang.module.config.MetaPool;
import com.liyang.module.spring.SpringContextHolder;
import com.liyang.webadmin.entity.User;
import com.liyang.webadmin.persistence.mapper.UserMapper;
import com.liyang.webadmin.service.SystemService;
import com.liyang.webadmin.web.sidebar.MetronicSidebarFactory;
import com.liyang.webadmin.web.sidebar.SidebarFactory;

public class AppTest extends TestCase{
	
protected ApplicationContext context;
	
	@Override
	protected void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
	}
	
	public void testA() {
		UserMapper userMapper = (UserMapper)context.getBean(UserMapper.class);
		User user = userMapper.findByUsername("lijieran");
		System.out.println(user.getPassword());
		
	}
	
	public void testFindUsers() {
		SidebarFactory sidebarFactory = (SidebarFactory)context.getBean(MetronicSidebarFactory.class);
		System.out.println(sidebarFactory.generateSidebar(""));
	}
	
	public void testMetaPool() {
		UserMapper userMapper = SpringContextHolder.getBean("userMapper");
		User user = userMapper.findByUsername("lijieran");
		System.out.println(user.getPassword());
		String label = MetaPool.getLabel("sex", "1");
		System.out.print(label);
	}

}