package com.isys622.schedulemanager.dao;

import java.util.List;

import com.isys622.schedulemanager.form.CreateShiftForm;
import com.isys622.schedulemanager.form.EmployeeForm;
import com.isys622.schedulemanager.form.SelectItem;


public interface ProfileDAO {

	public String createProfile(EmployeeForm form);
	public List<SelectItem> getAllManagers();
	public List<SelectItem> getAllEmployees(CreateShiftForm form);
	
}