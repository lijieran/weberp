package com.liyang.webadmin.service;


import java.util.List;

import com.liyang.module.authc.CheckboxEntity;
import com.liyang.webadmin.entity.Menu;
import com.liyang.webadmin.entity.Role;
import com.liyang.webadmin.entity.User;

public interface SystemService {
	
	public String findUsers();
	public User findByUsername(String username) throws Exception;
	public boolean checkLoginName(String username);
	public void saveUser(User entity);
	public void updateUser(User entity);
	public User findUserById(String id);
	public void deleteUser(String id);
	
	public String findMenus();
	public List<Menu> findTopMenus();
	public void saveMenu(Menu entity);
	public void deleteMenu(String id);
	public Menu findMenuById(String id);
	public void updateMenu(Menu entity);
	

	
	public void saveRole(Role entity);
	public void updateRole(Role entity);
	public String findRoles();
	public List<Role> findAllRole();
	public List<CheckboxEntity> findCheckboxRole(String userid);
	public Role findRoleById(String id);
	public void deleteRole(String id);

}
