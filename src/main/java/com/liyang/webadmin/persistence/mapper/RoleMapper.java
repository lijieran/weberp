package com.liyang.webadmin.persistence.mapper;

import java.util.List;

import com.liyang.webadmin.entity.Role;

public interface RoleMapper {
	
	void save(Role entity);
	void update(Role entity);
	void delete(String id);
	
	List<Role> findAll();
	
	Role findById(String id);
	
	void clearRoleMenu(String id);
	
	void saveRoleMenu(String roleid, String menuid);
	
	List<String> findMenusByRole(String roleid);
	

}
