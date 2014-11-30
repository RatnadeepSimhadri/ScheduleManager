package com.isys622.schedulemanager.handler;

import org.springframework.stereotype.Controller;

import com.isys622.schedulemanager.VO.ProfileVO;
import com.isys622.schedulemanager.dao.LoginDAO;
import com.isys622.schedulemanager.form.LoginForm;

@Controller

public class LoginHandler {

	public ProfileVO validateLoginCredentials(LoginForm loginForm){
		LoginDAO dao = new LoginDAO();
		return dao.validateLogin(loginForm.getUsername(), loginForm.getPassword());
		
	}
	
	
}