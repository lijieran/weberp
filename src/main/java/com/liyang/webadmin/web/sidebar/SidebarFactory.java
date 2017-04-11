package com.liyang.webadmin.web.sidebar;

public interface SidebarFactory {
	
	public String generateSidebar(String uri);
	
	public String generateSidebar(String uri, String username);

}
