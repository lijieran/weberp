package com.liyang.webadmin.persistence.mapper;

import java.util.List;

import com.liyang.module.authc.ZtreeEntity;
import com.liyang.webadmin.entity.Menu;

public interface MenuMapper {
	
	List<Menu> findMenus();
	
	void save(Menu entity);
	
	void delete(String id);
	void clearRoleMenu(String menuid);
	
	
	List<Menu> findChildren(String id);
	
	List<Menu> findAllChildren(String id);
	
	List<Menu> findDisplayChildren(String id);
	
	Menu findById(String id);
	
	void update(Menu entity);
	
	List<ZtreeEntity> findZtreeEntity();
	
	String findMaxId(String id);
	
	List<Menu> findByUsername(String username);

}
