package com.isys622.schedulemanager.form;


public class ShiftForm {

	private boolean selected;
	private int shiftNo;
	private String startTime;
	private String endTime;
	public int getShiftNo() {
		return shiftNo;
	}
	public void setShiftNo(int shiftNo) {
		this.shiftNo = shiftNo;
	}
	
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
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
}
