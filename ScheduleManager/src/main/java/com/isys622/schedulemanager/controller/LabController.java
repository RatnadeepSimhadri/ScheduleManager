package com.isys622.schedulemanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isys622.schedulemanager.form.EmployeeForm;
import com.isys622.schedulemanager.form.LabProfileForm;
import com.isys622.schedulemanager.form.SelectItem;
import com.isys622.schedulemanager.handler.LabHandler;
import com.isys622.schedulemanager.handler.ProfileHandler;

@Controller

public class LabController {

	@RequestMapping(value="/loadcreateLabProfile",method = RequestMethod.POST)
	public ModelAndView loadSearchSchedule(ModelMap model , @ModelAttribute("SpringWeb")LabProfileForm form) {
		
		LabHandler handler = new LabHandler();
		
		if(form.getOption().equals("C")){	
			List<SelectItem>managers = new ProfileHandler().getAllManagers();
			model.addAttribute("managers", managers);
			model.addAttribute("page","labProfile.jsp");
		}
		if(form.getOption().equals("S")){
			List<SelectItem>labs = handler.getAllLabs();
			List<SelectItem>days = handler.getAllDays();
			model.addAttribute("labs", labs);
			model.addAttribute("days", days);
			model.addAttribute("page","configureShifts.jsp");
		}
		
		return new ModelAndView("home", "command", form);
		

	}
	
	@RequestMapping(value="/createLabProfile",method = RequestMethod.POST)
	public ModelAndView createProfile(ModelMap model , @ModelAttribute("SpringWeb")LabProfileForm form) {
		
		LabHandler handler = new LabHandler();
		String result = handler.createLabProfile(form);	
		model.addAttribute("page","labProfile.jsp");
		model.addAttribute("form", form);
		model.addAttribute("result", result);
		return new ModelAndView("home", "command", form);
		

	}
	
	
	@RequestMapping(value="/configureShifts",method = RequestMethod.POST)
	public ModelAndView configureShifts(ModelMap model , @ModelAttribute("SpringWeb")LabProfileForm form) {
		
		LabHandler handler = new LabHandler();
		String result = handler.saveShiftDetails(form);
		model.addAttribute("page","configureShifts.jsp");
		List<SelectItem>labs = handler.getAllLabs();
		List<SelectItem>days = handler.getAllDays();
		model.addAttribute("labs", labs);
		model.addAttribute("days", days);
		model.addAttribute("form", form);
		model.addAttribute("result", result);
		return new ModelAndView("home", "command", form);
		

	}
	
	
}