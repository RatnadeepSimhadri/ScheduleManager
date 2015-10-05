/** 
 * 
 * File: WebConstants.java
 * Date: 09/26/2014
 * Course: ISYS 622 601
 * Description: Utility class that stores string Literals
 * 
 */
package com.isys622.schedulemanager.util;

public class Webconstants {

	
public static final String validateLogin = "{call validate_login(?,?)}";

public static final String validateUsername = "{call validate_username(?,?)}";

public static final String insertAddress = "INSERT INTO ADDRESS(street,city,state,zip) VALUES (?,?,?,?)";

public static final String createProfile = "{call create_emp_profile(?,?,?,?,?,?,?,?,?,?,?)}";

public static final String createLabProfile = "{call create_lab_profile(?,?,?)}";

public static final String getallLabs = "SELECT lab_id,name FROM lab";

public static final String getallManagers = "SELECT employee_id,first_name FROM employee WHERE role='M'";

public static final String savelabshifts = "{call save_lab_shifts(?,?,?,?,?)}";

public static final String getallShifts = "SELECT * FROM SHIFT WHERE lab_no= ? and shift_day= ? ";

public static final String getallEmployees = "SELECT employee_id,first_name FROM "
											+ "employee e , student_worker s WHERE e.employee_id=s.student_id AND s.lab=?";

public static final String saveallShifts = "INSERT INTO SCHEDULE(Date,lab,shift,student) VALUES (?,?,?,?) ";

public static final String saveallShiftDetails = "{call save_shift_details(?,?,?,?)}";

public static final String getSchedule = "SELECT s.start_time,s.end_time,s.shift_no,E.first_name, L.name FROM SCHEDULE SH , SHIFT S , EMPLOYEE E , Lab L  WHERE "
		+ "SH.shift=s.shift_id AND SH.student=E.employee_id AND SH.lab=L.lab_id AND SH.date=? and E.first_name = ?";

}