
/** 
 * 
 * File: DoctorRepositoryImplTest.java
 * Date: 09/26/2014
 * Course: ISYS 622 601
 * Description: Unit test class for DoctorRepositoryImpl
 * 
 */
package com.isys622.schedulemanager.handler;

import junit.framework.TestCase;

import com.isys622.schedulemanager.form.EmployeeForm;


public class ProfileHandlerTest extends TestCase {

	
	public void testcreateEmployeeProfile(){
		ProfileHandler testObj = new ProfileHandler();
		EmployeeForm form = new EmployeeForm();
		form.setUsername("ratna_simhadri");
		String result = testObj.createEmployeeProfile(form);
		assertEquals("Username already exists", result);
	}
	
}
