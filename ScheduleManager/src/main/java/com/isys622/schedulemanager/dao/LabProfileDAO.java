package com.isys622.schedulemanager.dao;

import java.util.List;

import com.isys622.schedulemanager.form.LabProfileForm;
import com.isys622.schedulemanager.form.SelectItem;



public interface LabProfileDAO {

	public String createLabProfile(LabProfileForm form);
	List<SelectItem> getAll();
	public String saveShiftDetails(LabProfileForm form);
	
}