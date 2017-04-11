package com.liyang.webadmin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liyang.module.authc.CheckboxEntity;
import com.liyang.webadmin.entity.Menu;
import com.liyang.webadmin.entity.Role;
import com.liyang.webadmin.entity.User;
import com.liyang.webadmin.persistence.mapper.MenuMapper;
import com.liyang.webadmin.persistence.mapper.RoleMapper;
import com.liyang.webadmin.persistence.mapper.UserMapper;
import com.liyang.webadmin.service.SystemService;

@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class SystemServiceImpl implements SystemService{
	
	private static Logger logger = Logger.getLogger(SystemServiceImpl.class);
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private MenuMapper menuMapper;
	
	@Resource
	private RoleMapper roleMapper;

	public String findUsers() {
        List<User> users = userMapper.findUsers();
                
       
        
        GsonBuilder gsonbuilder = new GsonBuilder().serializeNulls();
        Gson gson = gsonbuilder.create();
        
        Map map = new HashMap();
        map.put("draw", 0);
        map.put("recordsTotal", users.size());
        map.put("recordsFiltered", users.size());
        map.put("data", users);
        String json = gson.toJson(map);
		return json;
	}

	public boolean checkLoginName(String username) {
		User user = userMapper.findByUsername(username);
		if(user!=null) return false;
		return true;
	}

	@Transactional
	public void saveUser(User user) {
		try {
			user.setPassword(DigestUtils.md5Hex(user.getPassword()));
			userMapper.save(user);
			
			//保存角色信息
			
			if(user.getRoles()!=null) {
				String[] roles = user.getRoles().split(",");
				for(String roleid:roles) {
					userMapper.saveUserRole(user.getId(), roleid);
				}
			}
			
			
			
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	
	public String findMenus() {
		List<Menu> menus = menuMapper.findMenus();
        Gson gson = new Gson();
        Map map = new HashMap();
        map.put("draw", 0);
        map.put("recordsTotal", menus.size());
        map.put("recordsFiltered", menus.size());
        map.put("data", menus);
        String json = gson.toJson(map);
		return json;
	}

	public void saveMenu(Menu entity) {
		try {
			String maxid = menuMapper.findMaxId(entity.getParentId());
			String id = null;
			if(maxid==null ) {
				id =entity.getParentId() + "1";
			} else {
				id = (Integer.parseInt(maxid)+1) + "";
			}
			entity.setId(id);
			menuMapper.save(entity);
		} catch (Exception e) {
			logger.error(e,e);
		}
	}

	@Transactional
	public void deleteMenu(String id) {
		try {
			menuMapper.clearRoleMenu(id);
			menuMapper.delete(id);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}
	
	
/*	private List findChildrenMenus(String id) {
		List list = new ArrayList();
		try {
			
			List<Menu> children = menuMapper.findChildren(id);
			
			for(Menu menu : children) {
				Map map = new HashMap();
				if("1".equals(menu.getIsShow())) {
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
	}*/

	public Menu findMenuById(String id) {
		return menuMapper.findById(id);
	}

	public void updateMenu(Menu entity) {
		menuMapper.update(entity);
		
	}

	

	



	@Transactional
	public void saveRole(Role entity) {
		try {
			
			roleMapper.clearRoleMenu(entity.getId());
			
			roleMapper.save(entity);
			
			String[] ids = entity.getMenus().split(",");
			for(String id:ids) {
				if(StringUtils.isEmpty(id)) continue;
				roleMapper.saveRoleMenu(entity.getId(), id);
			}
			
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public String findRoles() {
		try {
			List<Role> list = roleMapper.findAll();
			Map map = new HashMap();
	        map.put("draw", 0);
	        map.put("recordsTotal", list.size());
	        map.put("recordsFiltered", list.size());
	        map.put("data", list);
	        Gson gson = new Gson();
	        String json = gson.toJson(map);
			return json;
		} catch (Exception e) {
			logger.error(e,e);
			return null;
		}
	}

	public Role findRoleById(String id) {
		try {
			return roleMapper.findById(id);
		} catch (Exception e) {
			logger.error(e,e);
		}
		return null;
	}



	@Transactional
	public void updateRole(Role entity) {
		try {
			roleMapper.clearRoleMenu(entity.getId());
			
			roleMapper.update(entity);
			
			String[] ids = entity.getMenus().split(",");
			for(String id:ids) {
				roleMapper.saveRoleMenu(entity.getId(), id);
			}
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}

	@Transactional
	public void deleteRole(String id) {
		try {
			roleMapper.clearRoleMenu(id);
			roleMapper.delete(id);
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public List<Role> findAllRole() {
		return roleMapper.findAll();
	}

	public List<CheckboxEntity> findCheckboxRole(String userid) {
		List<CheckboxEntity> result = new ArrayList<CheckboxEntity>();
		try {
			List<String> roles = null;
			if(userid!=null) {
		        roles = userMapper.findRoles(userid);
			}
			List<Role> list = roleMapper.findAll();
			for(Role role:list) {
				CheckboxEntity entity = new CheckboxEntity();
				entity.setChecked(false);
				entity.setName(role.getName());
				entity.setValue(role.getId());
				if(roles!=null && roles.contains(role.getId())) entity.setChecked(true);
				result.add(entity);
			}	
			
			
		} catch (Exception e) {
			logger.error(e,e);
		}
		return result;
	}

	@Transactional
	public void updateUser(User entity) {
		try {
			
			//处理密码更新
			if(entity.getPassword().length()!=32) {
				entity.setPassword(DigestUtils.md5Hex(entity.getPassword()));;
				
			}
			
			userMapper.update(entity);
			userMapper.clearUserRole(entity.getId());
			
			//保存角色信息
			
			if(entity.getRoles()!=null) {
				String[] roles = entity.getRoles().split(",");
				for(String roleid:roles) {
					userMapper.saveUserRole(entity.getId(), roleid);
				}
			}
			
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public User findUserById(String id) {
		try {
			return userMapper.findById(id);
		} catch (Exception e) {
			logger.error(e,e);
		}
		return null;
	}

	@Transactional
	public void deleteUser(String id) {
		try {
			userMapper.clearUserRole(id);
			userMapper.delete(id);
			
		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}

	public List<Menu> findTopMenus() {
		// TODO Auto-generated method stub
		return menuMapper.findTopMenus();
	}


}
