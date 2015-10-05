package com.isys622.schedulemanager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isys622.schedulemanager.form.CreateShiftForm;
import com.isys622.schedulemanager.form.SelectItem;
import com.isys622.schedulemanager.form.ShiftForm;
import com.isys622.schedulemanager.handler.ProfileHandler;
import com.isys622.schedulemanager.handler.ShiftHandler;

@Controller

public class ShiftController {

	@RequestMapping(value="/loadAssignShift",method = RequestMethod.POST)
	public ModelAndView loadSearchSchedule(ModelMap model , @ModelAttribute("SpringWeb") CreateShiftForm form) {
		
		ShiftHandler handler = new ShiftHandler();
		ProfileHandler profileHandler = new ProfileHandler();
	
		List<ShiftForm> shifts =handler.loadShiftDetails(form);
		List <SelectItem> employees=profileHandler.getAllEmployees(form);
		model.addAttribute("shifts", shifts);
		if(shifts!=null){
		model.addAttribute("size", shifts.size());
		}
		model.addAttribute("employees", employees);
		
		model.addAttribute("page","shift.jsp");	
		return new ModelAndView("home", "command", form);
		
	}
	
	@RequestMapping(value="/saveShifts",method = RequestMethod.POST)
	public ModelAndView saveShiftetails(ModelMap model , @ModelAttribute("SpringWeb") CreateShiftForm form ,HttpServletRequest request) {
		
		ShiftHandler handler = new ShiftHandler();
	
		
		String size= request.getParameter("size");
		Integer sizeint = new Integer(size);
		String employee = null;
		Map <Integer,Integer> shiftMap = new HashMap<Integer, Integer>();
		for (int i = 1; i <= sizeint; i++) {
		 employee= request.getParameter("shift"+i);
		 if(employee!=null && new Integer(employee)!=0){
		 shiftMap.put(i, new Integer(employee));
		 }
		 else{
			 shiftMap.put(i, new Integer(0)); 
		 }
		}
		
		String result =handler.saveShifts(form,shiftMap);
		model.addAttribute("result", result);
		model.addAttribute("page","shift.jsp");
		return new ModelAndView("home", "command", form);
		

	}
	
	
}