
use `schedule_manager` $

DROP PROCEDURE IF EXISTS schedule_manager.validate_login $
/** 
 * 
 * Name: validate_login
 * Date: 11/26/2014
 * Course: ISYS 622 601
 * Description: Validates Login Credentials
 * 
 */

CREATE PROCEDURE schedule_manager.validate_login ( IN p_username VARCHAR(20), 
IN p_password VARCHAR(20))
BEGIN


	SELECT U.username, U.password , E.role , U.employee  
	FROM USER U, EMPLOYEE E WHERE U.employee = E.employee_id
	AND U.username = p_username AND  U.password= p_password;

END $

DROP PROCEDURE IF EXISTS schedule_manager.validate_username $
/** 
 * 
 * Name: validate_login
 * Date: 11/26/2014
 * Course: ISYS 622 601
 * Description: Validates Login Credentials
 * 
 */

CREATE PROCEDURE schedule_manager.validate_username ( IN p_username VARCHAR(20), 
OUT p_result VARCHAR(20))
BEGIN
	DECLARE v_username VARCHAR(20) DEFAULT "";

	SELECT username INTO v_username FROM USER WHERE username = p_username; 

	IF (v_username!="") THEN
	SET p_result = 'exists';
	END IF;


END $

DROP PROCEDURE IF EXISTS schedule_manager.create_emp_profile $
/** 
 * 
 * Name: create_emp_profile
 * Date: 11/26/2014
 * Course: ISYS 622 601
 * Description: Creates Employee Profile
 * 
 */

CREATE PROCEDURE schedule_manager.create_emp_profile ( IN p_net_id VARCHAR(20), IN p_firstname VARCHAR(20), IN p_lastname VARCHAR(20),
IN p_address INTEGER(11),IN p_email VARCHAR(30),IN p_gender VARCHAR(1), IN p_contact BIGINT(20),
IN p_role VARCHAR(1),IN p_username VARCHAR(20), IN p_password VARCHAR(20),IN p_lab INTEGER(11) )
BEGIN
 DECLARE v_employeeid INTEGER DEFAULT 0;

	INSERT INTO employee(net_id,first_name,last_name,address,email,gender,contact_no,role) values
	(p_net_id,p_firstname,p_lastname,p_address,p_email,p_gender,p_contact,p_role);

	SELECT LAST_INSERT_ID() INTO v_employeeid;

	INSERT INTO USER(username,password,employee) VALUES (p_username,p_password,v_employeeid);

	IF (p_role='M') THEN
	INSERT INTO MANAGER(manager_id) VALUES (v_employeeid);
	END IF;

	IF (p_role='S') THEN
	INSERT INTO STUDENT_WORKER(student_id,lab) VALUES (v_employeeid,p_lab);
	END IF;



END $


DROP PROCEDURE IF EXISTS schedule_manager.create_lab_profile $
/** 
 * 
 * Name: create_emp_profile
 * Date: 11/26/2014
 * Course: ISYS 622 601
 * Description: Creates Employee Profile
 * 
 */

CREATE PROCEDURE schedule_manager.create_lab_profile ( IN p_name VARCHAR(20),IN p_address INTEGER(11),
IN p_manager INTEGER(11) )
BEGIN


	INSERT INTO lab(name,address,manager_id) values
	(p_name,p_address,p_manager);


END $

DROP PROCEDURE IF EXISTS schedule_manager.save_lab_shifts $
/** 
 * 
 * Name: create_emp_profile
 * Date: 11/26/2014
 * Course: ISYS 622 601
 * Description: Creates Employee Profile
 * 
 */

CREATE PROCEDURE schedule_manager.save_lab_shifts ( IN p_shift_no INTEGER(11),IN p_lab_no INTEGER(11),
IN p_day INTEGER(1),IN p_start_time VARCHAR(20),IN p_end_time VARCHAR(20))
BEGIN

	DECLARE v_shiftid INT(11) DEFAULT 0;
	DECLARE v_update INT(1) DEFAULT 0;

	SELECT shift_id INTO v_shiftid FROM SHIFT 
	WHERE shift_no=p_shift_no AND lab_no=p_lab_no AND shift_day=p_day;

	IF (v_shiftid = 0) THEN
	
	INSERT INTO SHIFT(shift_no,lab_no,shift_day,start_time,end_time) 
	VALUES(p_shift_no,p_lab_no,p_day,p_start_time,p_end_time);
	
	END IF;
	
	
	
	IF (v_shiftid != 0) THEN

	UPDATE SHIFT SET start_time= p_start_time,end_time=p_end_time
	WHERE shift_no=p_shift_no AND lab_no=p_lab_no AND shift_day=p_day;
	
	END IF;

	

END $


DROP PROCEDURE IF EXISTS schedule_manager.save_shift_details $
/** 
 * 
 * Name: create_emp_profile
 * Date: 11/26/2014
 * Course: ISYS 622 601
 * Description: Creates Employee Profile
 * 
 */

CREATE PROCEDURE schedule_manager.save_shift_details ( IN p_date DATE ,IN p_lab_no INTEGER(11),
IN p_shift_no INTEGER(11),IN p_student INTEGER(11))
BEGIN

	DECLARE v_schedule_Id INT(11) DEFAULT 0;

	SELECT schedule_id INTO v_schedule_Id FROM schedule 
	WHERE Date=p_date AND lab=p_lab_no AND shift=p_shift_no;
	
	IF(p_student=0) THEN
	SET p_student = NULL;
	END IF;

	IF (v_schedule_Id = 0) THEN
	
	INSERT INTO schedule(Date,lab,shift,student) 
	VALUES(p_date,p_lab_no,p_shift_no,p_student);
	END IF;
	
	IF (v_schedule_Id != 0) THEN
	
	

	UPDATE schedule SET student= p_student
	WHERE Date=p_date AND lab=p_lab_no AND shift=p_shift_no;
	
	END IF;

END $

