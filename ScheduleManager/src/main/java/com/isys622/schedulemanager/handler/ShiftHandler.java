package com.isys622.schedulemanager.handler;

import java.util.List;
import java.util.Map;

import com.isys622.schedulemanager.dao.ShiftDAO;
import com.isys622.schedulemanager.dao.ShiftDAOImplementation;
import com.isys622.schedulemanager.form.CreateShiftForm;
import com.isys622.schedulemanager.form.SearchScheduleForm;
import com.isys622.schedulemanager.form.ShiftForm;

public class ShiftHandler {

	public List<ShiftForm>  loadShiftDetails(CreateShiftForm form) {
		
		ShiftDAO dao = new ShiftDAOImplementation();
		List<ShiftForm> shifts = dao.getShiftsForADay(form);
		return shifts;
		
	}

	public String saveShifts(CreateShiftForm form, Map<Integer, Integer> shiftMap) {
		ShiftDAO dao = new ShiftDAOImplementation();
		return dao.saveShifts(form, shiftMap);
	}

	public void getScheduleforDay(SearchScheduleForm form) {
		ShiftDAO dao = new ShiftDAOImplementation();
		 dao.getScheduleforDay(form);
	}

}
