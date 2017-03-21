package com.liyang.webadmin.web.sidebar;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.liyang.webadmin.entity.Constant;
import com.liyang.webadmin.entity.Menu;
import com.liyang.webadmin.persistence.mapper.MenuMapper;

public class AceSidebarFactory implements SidebarFactory{
	
	private static Logger logger = Logger.getLogger(AceSidebarFactory.class);
	
	@Resource
	private MenuMapper menuMapper;

	public String generateSidebar(String uri) {
		List<Menu> menus = menuMapper.findChildren(Constant.MENU_ROOT_ID);
		
		StringBuffer buffer = new StringBuffer();
		
		
		for(Menu entity:menus) {
			this.formatSidebar(entity, buffer, uri);
						
		}
		return buffer.toString();
	}

	private void formatSidebar(Menu entity, StringBuffer buffer, String uri) {
		try {
			
			if(entity.getStatus().equals("0")) return;
			
			/*if(uri.contains("Update") || uri.contains("Add")) {
				String tmp = uri.substring(uri.lastIndexOf("/"));
				uri = uri.replace(tmp, "/index");
			}*/
			
			List<Menu> children = menuMapper.findDisplayChildren(entity.getId());
			
			String titleTag = "<li>";
			String icon = entity.getIcon();
			if(icon==null) icon="icon-desktop";
			
			if(children.size()==0) {
				
				//如果是单个菜单的情况
				if(uri.equalsIgnoreCase(entity.getHref())) titleTag = "<li class=\"active\">";
				
				buffer.append(titleTag);
				  buffer.append("<a href=\"##ROOT##"+entity.getHref()+"\">");
				    buffer.append("<i class=\""+icon+"\"></i>");
				    buffer.append("<span class=\"menu-text\"> "+entity.getName()+" </span>");
				  buffer.append("</a>");
				buffer.append("</li>");
				
			} else {
				
				boolean active = this.validateActive(menuMapper.findAllChildren(entity.getId()), uri);
				
				  if(active) buffer.append("<li class=\"active open\">");
				  else buffer.append("<li>");
				  
				  buffer.append("<a href=\"#\" class=\"dropdown-toggle\">");
				  buffer.append("<i class=\""+icon+"\"></i>");
				  buffer.append("<span class=\"menu-text\"> "+entity.getName()+" </span>");
				  buffer.append("<b class=\"arrow icon-angle-down\"></b>");
				  buffer.append("</a>");
				  
				  buffer.append("<ul class=\"submenu\">");
				  
				  for(Menu child:children) {
					  
					  if(uri.equals(child.getHref())) {
						  titleTag = "<li class=\"active\">";
					  } else {
						  titleTag = "<li>";
					  }
					  
					  buffer.append(titleTag);
					  buffer.append("<a href=\"##ROOT##"+child.getHref()+"\">");
					  buffer.append("<i class=\"icon-double-angle-right\"></i>");
					  buffer.append(child.getName());
					  buffer.append("</a>");
					  buffer.append("</li>");
				  }
				  
				  buffer.append("</ul>");
				buffer.append("</li>");
				
				
			}

		} catch (Exception e) {
			logger.error(e,e);
		}
		
	}
	
	private boolean validateActive(List<Menu> children, String uri) {
		for(Menu entity:children) {
			if(entity==null) continue;
			if(uri.equals(entity.getHref())) return true;
		}
		return false;
	}

}
