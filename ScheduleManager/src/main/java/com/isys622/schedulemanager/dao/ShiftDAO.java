package com.isys622.schedulemanager.dao;

import java.util.List;
import java.util.Map;

import com.isys622.schedulemanager.form.CreateShiftForm;
import com.isys622.schedulemanager.form.SearchScheduleForm;
import com.isys622.schedulemanager.form.ShiftForm;



public interface ShiftDAO {

	
	public List<ShiftForm> getShiftsForADay(CreateShiftForm form);
	public String saveShifts(CreateShiftForm form, Map<Integer, Integer> shiftMap);
	public void getScheduleforDay(SearchScheduleForm form);

	
}