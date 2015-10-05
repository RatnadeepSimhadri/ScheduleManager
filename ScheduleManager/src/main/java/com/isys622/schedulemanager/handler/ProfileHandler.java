package com.isys622.schedulemanager.handler;

import java.util.List;

import com.isys622.schedulemanager.dao.LabProfileDAO;
import com.isys622.schedulemanager.dao.LabProfileDAOImplementation;
import com.isys622.schedulemanager.dao.ProfileDAO;
import com.isys622.schedulemanager.dao.ProfileDAOImplementation;
import com.isys622.schedulemanager.form.CreateShiftForm;
import com.isys622.schedulemanager.form.EmployeeForm;
import com.isys622.schedulemanager.form.SelectItem;

public class ProfileHandler {

	public void loadEmployeeDetails(EmployeeForm form) {
		
		
	}

	public String createEmployeeProfile(EmployeeForm form) {
	
		ProfileDAO dao = new ProfileDAOImplementation();
		 return dao.createProfile(form);
		
	}
	
	public List<SelectItem> getAllManagers(){
		ProfileDAO dao = new ProfileDAOImplementation();
		return dao.getAllManagers();
		
	}
	
	public List<SelectItem> getAllEmployees(CreateShiftForm form){
		ProfileDAO dao = new ProfileDAOImplementation();
		return dao.getAllEmployees(form);
		
	}

}
