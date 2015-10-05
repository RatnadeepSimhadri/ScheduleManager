package com.isys622.schedulemanager.dao;

import com.isys622.schedulemanager.VO.ProfileVO;


public interface LoginDAO {

	public ProfileVO validateLogin(String username, String password);
	
}