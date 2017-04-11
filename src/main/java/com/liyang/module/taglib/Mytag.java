package com.liyang.module.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Mytag extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		// 获取页面输出流，并输出字符串
		getJspContext().getOut().write("Hello World");
	}

}
