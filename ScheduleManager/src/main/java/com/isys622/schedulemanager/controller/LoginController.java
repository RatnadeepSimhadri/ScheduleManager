package com.isys622.schedulemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isys622.schedulemanager.form.LoginForm;

@Controller

public class LoginController {

	@RequestMapping(value="/welcome",method = RequestMethod.GET)
	public ModelAndView login(ModelMap model) {

		return new ModelAndView("login", "command", new LoginForm());

	}
	
}