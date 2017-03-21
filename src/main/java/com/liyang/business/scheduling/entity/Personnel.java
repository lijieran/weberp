package com.liyang.business.scheduling.entity;

import com.liyang.business.Entity;


/**
 * 参与排班人员
 * @author lijieran
 *
 */
public class Personnel extends Entity{
	
	private int id;
	private String name; // 姓名
	private String displayColor; // 展示颜色
	private String allowEditing; // 是否允许编辑。１＝是，０＝不是，默认0禁止编辑
	private Department department;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayColor() {
		return displayColor;
	}
	public void setDisplayColor(String displayColor) {
		this.displayColor = displayColor;
	}
	public String getAllowEditing() {
		return allowEditing;
	}
	public void setAllowEditing(String allowEditing) {
		this.allowEditing = allowEditing;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

}
