package com.isys622.schedulemanager.VO;

public class ScheduleVO {

	private String startTime;
	private String endTime;
	private int shiftNumber;
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
	public int getShiftNumber() {
		return shiftNumber;
	}
	public void setShiftNumber(int shiftNumber) {
		this.shiftNumber = shiftNumber;
	}
}
