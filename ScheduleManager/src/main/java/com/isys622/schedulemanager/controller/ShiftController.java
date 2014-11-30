package com.isys622.schedulemanager.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isys622.schedulemanager.form.CreateShiftForm;
import com.isys622.schedulemanager.handler.ShiftHandler;

@Controller

public class ShiftController {

	@RequestMapping(value="/loadAssignShift",method = RequestMethod.POST)
	public ModelAndView loadSearchSchedule(ModelMap model , @ModelAttribute("SpringWeb") CreateShiftForm form) {
		
		ShiftHandler handler = new ShiftHandler();
	
			handler.loadShiftDetails(form);	
			model.addAttribute("shifts", 3);
			model.addAttribute("noofworkers",2);
		
		model.addAttribute("page","shift.jsp");	
		return new ModelAndView("home", "command", form);
		

	}
	
	@RequestMapping(value="/saveShifts",method = RequestMethod.POST)
	public ModelAndView saveShiftetails(ModelMap model , @ModelAttribute("SpringWeb") CreateShiftForm form ,HttpServletRequest request) {
		
		ShiftHandler handler = new ShiftHandler();
	
		
		String value2= request.getParameter("token");
		model.addAttribute("page","shift.jsp");
		return new ModelAndView("home", "command", form);
		

	}
	
	
}