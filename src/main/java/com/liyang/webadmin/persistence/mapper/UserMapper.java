package com.liyang.webadmin.persistence.mapper;

import java.util.List;

import com.liyang.webadmin.entity.User;

public interface UserMapper {
	
	User findByUsername(String username);
	
	User findById(String id);
	
	List<User> findUsers();
	
	void save(User user);
	
	List<String> findRoles(String id);
	
	void saveUserRole(String userid, String roleid);
	
	void clearUserRole(String userid);
	
	void update(User user);

	
	void delete(String id);
}
