package com.isys622.schedulemanager.form;

import java.util.Date;
import java.util.List;

import com.isys622.schedulemanager.VO.ScheduleVO;

public class SearchScheduleForm {
	private Integer employeeId;
    private Date date;
    private String name;
    private String labName;
    
    private List<ScheduleVO> schedule;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ScheduleVO> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<ScheduleVO> schedule) {
		this.schedule = schedule;
	}
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	
}
