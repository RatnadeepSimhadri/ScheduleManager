package com.isys622.schedulemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isys622.schedulemanager.form.EmployeeForm;
import com.isys622.schedulemanager.form.LoginForm;
import com.isys622.schedulemanager.form.SearchScheduleForm;
import com.isys622.schedulemanager.handler.ProfileHandler;

@Controller

public class ProfileController {

	@RequestMapping(value="/loadcreateProfile",method = RequestMethod.POST)
	public ModelAndView loadSearchSchedule(ModelMap model , @ModelAttribute("SpringWeb")EmployeeForm form) {
		
		ProfileHandler handler = new ProfileHandler();
		
		if(form.getOption().equals("U")){
			handler.loadEmployeeDetails(form);	
		}
		
		model.addAttribute("page","profile.jsp");
		return new ModelAndView("home", "command", form);
		

	}
	
	@RequestMapping(value="/createProfile",method = RequestMethod.POST)
	public ModelAndView createProfile(ModelMap model , @ModelAttribute("SpringWeb")EmployeeForm form) {
		
		ProfileHandler handler = new ProfileHandler();
		
		if(form.getOption().equals("U")){
			handler.createEmployeeProfile(form);	
		}
		
		model.addAttribute("page","profile.jsp");
		return new ModelAndView("home", "command", form);
		

	}
	
	
}