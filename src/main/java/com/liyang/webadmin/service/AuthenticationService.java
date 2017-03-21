package com.liyang.webadmin.service;

import java.util.List;

import com.liyang.webadmin.entity.Menu;
import com.liyang.webadmin.entity.User;

public interface AuthenticationService {
	
	public User findByUsername(String username) ;
	
	public List<Menu> findByUser(String userid);
	
	public String ztreeMenu();
	
	public String ztreeMenu(String roleid);
	
	public String combotreeMenu();

}
