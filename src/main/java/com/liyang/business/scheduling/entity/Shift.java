package com.liyang.business.scheduling.entity;

import com.liyang.business.Entity;


/**
 * 班次
 * @author lijieran
 *
 */
public class Shift extends Entity{
	
	private int id;
	private String name; // 名称
	private String alias; // 别名
	private String code; // 班次代码
	private String startTime; // 开始时间
	private String endTime; // 结束时间
	private String shiftTimeStart; // 交班开始时间
	private String shiftTimeEnd; // 交班结束时间
	private String takeoverTimeStart; // 接班开始时间
	private String takeoverTimeEnd; // 接班结束时间
	private int sort; // 排序号
	private String enabled; // 是否可用，开启/关闭。1表示开启，0表示关闭，默认是关闭
	private String daySpan; // 是否跨天。１＝是， ０＝不是。 默认0不是
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
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getShiftTimeStart() {
		return shiftTimeStart;
	}
	public void setShiftTimeStart(String shiftTimeStart) {
		this.shiftTimeStart = shiftTimeStart;
	}
	public String getShiftTimeEnd() {
		return shiftTimeEnd;
	}
	public void setShiftTimeEnd(String shiftTimeEnd) {
		this.shiftTimeEnd = shiftTimeEnd;
	}
	public String getTakeoverTimeStart() {
		return takeoverTimeStart;
	}
	public void setTakeoverTimeStart(String takeoverTimeStart) {
		this.takeoverTimeStart = takeoverTimeStart;
	}
	public String getTakeoverTimeEnd() {
		return takeoverTimeEnd;
	}
	public void setTakeoverTimeEnd(String takeoverTimeEnd) {
		this.takeoverTimeEnd = takeoverTimeEnd;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getDaySpan() {
		return daySpan;
	}
	public void setDaySpan(String daySpan) {
		this.daySpan = daySpan;
	}
	
	

}
