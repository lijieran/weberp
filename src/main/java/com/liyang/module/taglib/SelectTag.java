package com.liyang.module.taglib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.liyang.module.config.MetaPool;
import com.liyang.module.config.entity.Meta;

public class SelectTag extends SimpleTagSupport{
	
	private static Logger logger = Logger.getLogger(SelectTag.class);
	
	private String name;
	private String value;
	private String cssClass;
	private String metaType;
	
	private StringBuilder output = new StringBuilder();
	
	public void doTag() throws JspException, IOException {
		try {
			// 获取页面输出流，并输出字符串
			output.append("<select class=\""+cssClass+"\" name=\""+name+"\">");
			
			List<Meta> metaList = MetaPool.getMetaList(metaType);
			
			for (Meta meta : metaList) {
				String label = meta.getLabel(), cvalue = meta.getValue();
				if(cvalue.equals(value)) {
					output.append("<option value=\""+cvalue+"\"  selected>"+label+"</option>");
				} else {
					output.append("<option value=\""+cvalue+"\" >"+label+"</option>");
				}
				
					
			}
			
			
			output.append("</select>");
			getJspContext().getOut().write(output.toString());
		} catch (Exception e) {
			logger.error(e,e);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getMetaType() {
		return metaType;
	}

	public void setMetaType(String metaType) {
		this.metaType = metaType;
	}
	
	


}
