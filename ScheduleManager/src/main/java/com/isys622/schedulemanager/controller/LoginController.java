package com.isys622.schedulemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isys622.schedulemanager.VO.ProfileVO;
import com.isys622.schedulemanager.form.LoginForm;
import com.isys622.schedulemanager.form.SearchScheduleForm;
import com.isys622.schedulemanager.handler.LoginHandler;

@Controller

public class LoginController {

	@RequestMapping(value="/login",method = RequestMethod.GET)
	public ModelAndView home(ModelMap model) {

		return new ModelAndView("login", "command", new LoginForm());

	}
	
	@RequestMapping(value="/validateLogin",method = RequestMethod.POST)
	public ModelAndView login(ModelMap model, @ModelAttribute("SpringWeb")LoginForm loginForm) {
		
		LoginHandler handler = new LoginHandler();
		ProfileVO profile = handler.validateLoginCredentials(loginForm);
		
		if(profile!=null){
			model.addAttribute("validUser", "true");
			model.addAttribute("page", "searchSchedule.jsp");
		return new ModelAndView("home", "command", new SearchScheduleForm());
		}
		else
		{	
			model.addAttribute("validUser", "false");
			return new ModelAndView("login", "command", new LoginForm());
		}

	}
	
	
}