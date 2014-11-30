package com.isys622.schedulemanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isys622.schedulemanager.form.CreateShiftForm;
import com.isys622.schedulemanager.form.EmployeeForm;
import com.isys622.schedulemanager.form.SearchScheduleForm;
import com.isys622.schedulemanager.form.SelectItem;

@Controller

public class HomeController {

	@RequestMapping(value="/loadSearchSchedule",method = RequestMethod.POST)
	public ModelAndView loadSearchSchedule(ModelMap model) {

		return new ModelAndView("searchSchedule", "command", new SearchScheduleForm());

	}
	
	@RequestMapping(value="/loadProfilePage",method = RequestMethod.POST)
	public ModelAndView loadProfilePage(ModelMap model) {
		
		EmployeeForm form = new EmployeeForm();
		form.setOption("C");
		return new ModelAndView("createProfile", "command", form);
		

	}
	
	@RequestMapping(value="/loadSchedulePage",method = RequestMethod.POST)
	public ModelAndView loadSchedulePage(ModelMap model) {
		
		CreateShiftForm form = new CreateShiftForm();
		List<SelectItem>labs = new ArrayList<SelectItem>();
		labs.add(new SelectItem(1, "Blocker"));
		model.addAttribute("labs", labs);
		return new ModelAndView("searchShift", "command",form );

	}
	
	/*@RequestMapping(value="/loadCreateLabPage",method = RequestMethod.POST)
	public ModelAndView loadCreateLabPage(ModelMap model) {

		return new ModelAndView("searchSchedule", "command", new SearchScheduleForm());

	}*/
	
	
	
}