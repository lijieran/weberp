package com.liyang.module.authc;

import java.util.List;

public class CombotreeEntity {
	
	private String id;
	private String text;
	private List<CombotreeEntity> children;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<CombotreeEntity> getChildren() {
		return children;
	}
	public void setChildren(List<CombotreeEntity> children) {
		this.children = children;
	}
	
	

}
