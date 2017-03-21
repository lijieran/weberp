package com.liyang.webadmin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.liyang.module.authc.ZtreeEntity;
import com.liyang.webadmin.entity.Constant;
import com.liyang.webadmin.entity.Menu;
import com.liyang.webadmin.entity.User;
import com.liyang.webadmin.persistence.mapper.MenuMapper;
import com.liyang.webadmin.persistence.mapper.RoleMapper;
import com.liyang.webadmin.persistence.mapper.UserMapper;
import com.liyang.webadmin.service.AuthenticationService;


@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	
	private static Logger logger = Logger.getLogger(AuthenticationServiceImpl.class);
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private MenuMapper menuMapper;
	
	@Resource
	private RoleMapper roleMapper;

	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}
	
	public String ztreeMenu(String roleid) {
		try {

			List<ZtreeEntity> list = menuMapper.findZtreeEntity();
			
			List<String> menus = roleMapper.findMenusByRole(roleid);
			
			for(ZtreeEntity entity:list)	 {
				String id =  entity.getId();
				if(menus.contains(id)) entity.setChecked(true);
			}
			
			
			Gson gson = new Gson();

			return gson.toJson(list);

		} catch (Exception e) {
			logger.error(e, e);
		}
		return null;
	}
	
	public String ztreeMenu() {
		try {

			Gson gson = new Gson();

			return gson.toJson(menuMapper.findZtreeEntity());

		} catch (Exception e) {
			logger.error(e, e);
		}
		return null;
	}

	public String combotreeMenu() {
	try {
			
			Menu root = menuMapper.findById(Constant.MENU_ROOT_ID);
			
			List list = new ArrayList();
			
			Map rootMap = new HashMap();
			rootMap.put("id", root.getId());
			rootMap.put("text", root.getName());
			
			rootMap.put("children", this.findChildrenMenus(root.getId()));
			
			list.add(rootMap);
			
			Gson gson = new Gson( );
			
			
			return gson.toJson(list);
			
		} catch (Exception e) {
			logger.error(e,e);
		}
		return null;
	}
	
	private List findChildrenMenus(String id) {
		List list = new ArrayList();
		try {
			
			List<Menu> children = menuMapper.findChildren(id);
			
			for(Menu menu : children) {
				Map map = new HashMap();
				if("3".equals(menu.getStatus())) {
					map.put("id", menu.getId());
					map.put("text", menu.getName());
					map.put("children", this.findChildrenMenus(menu.getId()));
					list.add(map);
				}
				
			}
		} catch (Exception e) {
			logger.error(e,e);
		}
		return list;
	}

	public List<Menu> findByUser(String userid) {
		try {
			return menuMapper.findByUsername(userid);
		} catch (Exception e) {
			logger.error(e,e);
		}
		return null;
	}

}
