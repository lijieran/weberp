package com.liyang.webadmin.web.sidebar;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.liyang.webadmin.entity.Constant;
import com.liyang.webadmin.entity.Menu;
import com.liyang.webadmin.persistence.mapper.MenuMapper;

@Service(value="metronicSidebarFactory")
public class MetronicSidebarFactory implements SidebarFactory{
	
	private static Logger logger = Logger.getLogger(MetronicSidebarFactory.class);
	
	@Resource
	private MenuMapper menuMapper;

	public String generateSidebar(String uri) {
		List<Menu> menus = menuMapper.findChildren(Constant.MENU_ROOT_ID);
		
		StringBuffer buffer = new StringBuffer();
		
		
		for(Menu entity:menus) {
			this.formatSidebar(entity, buffer, uri, null);
						
		}
		return buffer.toString();
	}

	private void formatSidebar(Menu entity, StringBuffer buffer, String uri, String username) {
		try {
			logger.info("请求的uri="+uri);
			uri = uri.replace("add", "index");
			uri = uri.replace("update", "index");
			if(entity.getStatus().equals("0")) return;
			
			String tmp = uri.substring(uri.lastIndexOf("/"));
			uri = uri.replace(tmp, "/index");
			
			/*if(uri.contains("Update") || uri.contains("Add")) {
				String tmp = uri.substring(uri.lastIndexOf("/"));
				uri = uri.replace(tmp, "/index");
			}*/
			
			List<Menu> children = null;
			
			if(username==null) {
				children = menuMapper.findDisplayChildren(entity.getId());
			} else {
				children = menuMapper.findByUsernameAndParentId(entity.getId(), username);
			}
			
			String titleTag = "<li>";
			String icon = entity.getIcon();
			if(icon==null) icon="icon-desktop";
			
			if(children.size()==0) {
				
				//如果是单个菜单的情况
				if(uri.equalsIgnoreCase(entity.getHref())) titleTag = "<li class=\"start active\">";
				
				buffer.append(titleTag);
				  buffer.append("<a href=\"##ROOT##"+entity.getHref()+"\">");
				    buffer.append("<i class=\""+icon+"\"></i>");
				    buffer.append("<span class=\"title\"> "+entity.getName()+" </span>");
				    buffer.append("<span class=\"selected\"></span>");
				  buffer.append("</a>");
				buffer.append("</li>");
				
			} else {
				
				boolean active = this.validateActive(menuMapper.findAllChildren(entity.getId()), uri);
				
				  if(active) buffer.append("<li class=\"active open\">");
				  else buffer.append("<li>");
				  
				  buffer.append("<a href=\"#\" class=\"dropdown-toggle\">");
				  buffer.append("<i class=\""+icon+"\"></i>");
				  buffer.append("<span class=\"title\"> "+entity.getName()+" </span>");
				  
				  if(active) {
					  buffer.append("<span class=\"selected\"></span>");
					  buffer.append("<span class=\"arrow open\"></span>");
				  } else {
					  buffer.append("<span class=\"arrow \"></span>");
				  }
				  
				  buffer.append("</a>");
				  
				  buffer.append("<ul class=\"sub-menu\">");
				  
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

	public String generateSidebar(String uri, String username) {
		List<Menu> menus = menuMapper.findByUsernameAndParentId(Constant.MENU_ROOT_ID, username);
		
		StringBuffer buffer = new StringBuffer();
		
		
		for(Menu entity:menus) {
			this.formatSidebar(entity, buffer, uri, username);
						
		}
		return buffer.toString();
	}

}
