package com.isys622.schedulemanager.form;

import java.util.ArrayList;
import java.util.List;

import com.isys622.schedulemanager.VO.AddressVO;



public class LabProfileForm {
	
	
	private String option;
	private Integer labId;
	private String labName;
	private AddressVO address;
	private Integer manager;
	private ShiftForm shiftone;
	private ShiftForm shifttwo;
	private ShiftForm shiftthree;
	private ShiftForm shiftfour;
	private ShiftForm shiftfive;
	private ShiftForm shiftsix;
	private Integer day;
	

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Integer getLabId() {
		return labId;
	}

	public void setLabId(Integer labId) {
		this.labId = labId;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public AddressVO getAddress() {
		return address;
	}

	public void setAddress(AddressVO address) {
		this.address = address;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public ShiftForm getShiftone() {
		return shiftone;
	}

	public void setShiftone(ShiftForm shiftone) {
		this.shiftone = shiftone;
	}

	public ShiftForm getShifttwo() {
		return shifttwo;
	}

	public void setShifttwo(ShiftForm shifttwo) {
		this.shifttwo = shifttwo;
	}

	public ShiftForm getShiftthree() {
		return shiftthree;
	}

	public void setShiftthree(ShiftForm shiftthree) {
		this.shiftthree = shiftthree;
	}

	public ShiftForm getShiftfour() {
		return shiftfour;
	}

	public void setShiftfour(ShiftForm shiftfour) {
		this.shiftfour = shiftfour;
	}

	public ShiftForm getShiftfive() {
		return shiftfive;
	}

	public void setShiftfive(ShiftForm shiftfive) {
		this.shiftfive = shiftfive;
	}

	public ShiftForm getShiftsix() {
		return shiftsix;
	}

	public void setShiftsix(ShiftForm shiftsix) {
		this.shiftsix = shiftsix;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public List<ShiftForm> getAllShifts(){
		List<ShiftForm> shifts = new ArrayList<ShiftForm>();
		shifts.add(this.shiftone);
		shifts.add(this.shifttwo);
		shifts.add(this.shiftthree);
		shifts.add(this.shiftfour);
		shifts.add(this.shiftfive);
		shifts.add(this.shiftsix);
		return shifts;
	}
	
}
