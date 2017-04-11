package com.liyang.business;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.liyang.module.taglib.Option;
import com.liyang.module.taglib.OptionMapper;

public class MySelectTag extends SimpleTagSupport{
	
	private static Logger logger = Logger.getLogger(MySelectTag.class);
	
	private String name;
	private String value;
	private String cssClass;
	private String type;
	
	private StringBuilder output = new StringBuilder();
	
	public void doTag() throws JspException, IOException {
		try {
			// 获取页面输出流，并输出字符串
			output.append("<select class=\""+cssClass+"\" name=\""+name+"\">");
			
			this.generateOption();
			
			
			
			
			output.append("</select>");
			getJspContext().getOut().write(output.toString());
		} catch (Exception e) {
			logger.error(e,e);
		}
	}

	private void generateOption() {
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		OptionMapper optionMapper = null;
		/*if("supplierType".equals(type)) {
			optionMapper = (OptionMapper)webApplicationContext.getBean("supplierTypeMapper");
		} else if("paymentterms".equals(type)) {
			optionMapper = (OptionMapper)webApplicationContext.getBean("paymenttermsMapper");
		} else if("currencies".equals(type)) {
			optionMapper = (OptionMapper)webApplicationContext.getBean("currenciesMapper");
		} else if("country".equals(type)) {
			optionMapper = (OptionMapper)webApplicationContext.getBean("countryMapper");
		}*/
		if(type!=null) {
			optionMapper = (OptionMapper)webApplicationContext.getBean(type+"Mapper");
		}
		
		List<Option> options = optionMapper.findOptions();
		
		for (Option option : options) {
			String label = option.getName(), cvalue = option.getValue();
			if(cvalue.equals(value)) {
				output.append("<option value=\""+cvalue+"\"  selected>"+label+"</option>");
			} else {
				output.append("<option value=\""+cvalue+"\" >"+label+"</option>");
			}
			
				
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	

}
