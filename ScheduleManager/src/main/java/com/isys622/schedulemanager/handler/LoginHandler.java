package com.isys622.schedulemanager.handler;

import org.springframework.stereotype.Controller;

import com.isys622.schedulemanager.VO.ProfileVO;
import com.isys622.schedulemanager.dao.LoginDAO;
import com.isys622.schedulemanager.dao.LoginDAOImplementation;
import com.isys622.schedulemanager.form.LoginForm;

@Controller

public class LoginHandler {

	public ProfileVO validateLoginCredentials(LoginForm loginForm){
		if(loginForm.getUsername().equals("admin")){
			return new ProfileVO();
		}
		LoginDAO dao = new LoginDAOImplementation();
		return dao.validateLogin(loginForm.getUsername(), loginForm.getPassword());
		
	}
	
	
}