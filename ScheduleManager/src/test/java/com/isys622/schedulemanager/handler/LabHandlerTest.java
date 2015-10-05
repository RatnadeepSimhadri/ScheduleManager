
/** 
 * 
 * File: DoctorRepositoryImplTest.java
 * Date: 09/26/2014
 * Course: ISYS 622 601
 * Description: Unit test class for DoctorRepositoryImpl
 * 
 */
package com.isys622.schedulemanager.handler;

import java.util.List;

import junit.framework.TestCase;

import com.isys622.schedulemanager.VO.AddressVO;
import com.isys622.schedulemanager.form.LabProfileForm;
import com.isys622.schedulemanager.form.SelectItem;


public class LabHandlerTest extends TestCase {

	
	public void testcreateLabProfile(){
	LabHandler testobj = new LabHandler();
	LabProfileForm form = new LabProfileForm();
	form.setLabName("WCL");
	form.setManager(1);
	AddressVO address = new AddressVO();
	address.setCity("City");
	address.setState("State");
	address.setStreet("Street");
	address.setZip("12345");
	form.setAddress(address);
	String result=testobj.createLabProfile(form);
	assertEquals("Lab Created Successfully", result);
	}
	
	
	public void testgetAllLabs(){
		LabHandler testobj = new LabHandler();
		
		List<SelectItem> list=testobj.getAllLabs();
		assertEquals(1, list.size());
		}
	
	
	public void testgetAllDays(){
		LabHandler testobj = new LabHandler();
		
		List<SelectItem> list=testobj.getAllDays();
		assertEquals(7, list.size());
		}

}
