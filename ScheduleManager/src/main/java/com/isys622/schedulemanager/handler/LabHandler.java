package com.isys622.schedulemanager.handler;

import java.util.ArrayList;
import java.util.List;

import com.isys622.schedulemanager.dao.LabProfileDAO;
import com.isys622.schedulemanager.dao.LabProfileDAOImplementation;
import com.isys622.schedulemanager.form.LabProfileForm;
import com.isys622.schedulemanager.form.SelectItem;

public class LabHandler {


	public String createLabProfile(LabProfileForm form) {
		
		{
			
			LabProfileDAO dao = new LabProfileDAOImplementation();
			return dao.createLabProfile(form);
			
		}
		
	}
	
	public List<SelectItem> getAllLabs(){
		LabProfileDAO dao = new LabProfileDAOImplementation();
		return dao.getAll();
		
	}
	
	public List<SelectItem> getAllDays(){
		List<SelectItem> days = new ArrayList<SelectItem>();
		days.add(new SelectItem(0, "Sunday"));
		days.add(new SelectItem(1, "Monday"));
		days.add(new SelectItem(2, "Tuesday"));
		days.add(new SelectItem(3, "Wednesday"));
		days.add(new SelectItem(4, "Thursday"));
		days.add(new SelectItem(5, "Friday"));
		days.add(new SelectItem(6, "Saturday"));
		
		return days;
		
	}

	public String saveShiftDetails(LabProfileForm form) {
		LabProfileDAO dao = new LabProfileDAOImplementation();
		return dao.saveShiftDetails(form);
	}

}
