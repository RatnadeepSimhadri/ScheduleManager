

/*Database structure */
DROP DATABASE IF EXISTS `schedule_manager`$

CREATE DATABASE `schedule_manager`$ 

USE `schedule_manager`$

/* Address table*/
DROP TABLE IF EXISTS `address`$

CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `zip` varchar(20) NOT NULL,
PRIMARY KEY (`address_id`))$

/* Employee table*/
DROP TABLE IF EXISTS `employee`$

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `net_id` varchar(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,  
  `address` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,  
  `gender` varchar(1) NOT NULL,  
  `contact_no` BIGINT(20) NOT NULL,
  `role` varchar(1) NOT NULL,
PRIMARY KEY (`employee_id`),
foreign KEY (address) REFERENCES address(address_id) ON DELETE NO ACTION ON UPDATE NO ACTION
)$

/* User table*/
DROP TABLE IF EXISTS `user`$

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `employee` int(11) NOT NULL,
PRIMARY KEY (`username`),
foreign KEY (employee) REFERENCES employee(employee_id) ON DELETE NO ACTION ON UPDATE NO ACTION
)$

/* Manager table*/
DROP TABLE IF EXISTS `manager`$

CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL,
  PRIMARY KEY (`manager_id`),
  foreign KEY (manager_id) REFERENCES employee(employee_id) ON DELETE NO ACTION ON UPDATE NO ACTION
)$

/* Lab table*/
DROP TABLE IF EXISTS `lab`$

CREATE TABLE `lab` (
  `lab_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `address` int(11) NOT NULL,
  `manager_id` int(11) NOT NULL,
PRIMARY KEY (`lab_id`),
foreign KEY (address) REFERENCES address(address_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
foreign KEY (manager_id) REFERENCES manager(manager_id) ON DELETE NO ACTION ON UPDATE NO ACTION
)$

/* Shift table*/
DROP TABLE IF EXISTS `shift`$

CREATE TABLE `shift` (
  `shift_id` int(11) NOT NULL AUTO_INCREMENT,
  `shift_no` int(11) NOT NULL,
  `lab_no` int(11) NOT NULL,
  `start_time` varchar(10) NOT NULL,
  `end_time` varchar(10) NOT NULL,
  `shift_day` int(1) NOT NULL,
CONSTRAINT uc_shift UNIQUE (shift_no,lab_no,shift_day),
PRIMARY KEY (`shift_id`),
foreign KEY (lab_no) REFERENCES lab(lab_id) ON DELETE NO ACTION ON UPDATE NO ACTION)$

/* Student Worker Table*/
DROP TABLE IF EXISTS `student_worker`$

CREATE TABLE `student_worker` (
  `student_id` int(11) NOT NULL,
  `lab` int(11) NOT NULL,
PRIMARY KEY (`student_id`),
foreign KEY (student_id) REFERENCES employee(employee_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
foreign KEY (lab) REFERENCES lab(lab_id) ON DELETE NO ACTION ON UPDATE NO ACTION
)$


/* Schedule table*/
DROP TABLE IF EXISTS `schedule`$

CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `Date` Date,
  `lab` int(11),
  `shift` int(11),
  `student` int(11),
PRIMARY KEY (`schedule_id`),
CONSTRAINT uc_schedule UNIQUE (shift,lab,student,Date),
foreign KEY (shift) REFERENCES shift(shift_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
foreign KEY (lab) REFERENCES lab(lab_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
foreign KEY (student) REFERENCES student_worker(student_id) ON DELETE NO ACTION ON UPDATE NO ACTION
)$


INSERT INTO address(address_id,street,city,state,zip) VALUES (1,"4302 College Main","Bryan","TX","77801")$

INSERT INTO employee(employee_id,net_id,first_name,last_name,address,email,gender,contact_no,role) values
	(1,"ratna_simhadri","Ratna Deep","Simhadri", 1,"ratnadeep_s@yahoo.com","M","9797399437","M")$
	
INSERT INTO USER(username,password,employee) VALUES ("ratna_simhadri","12345", 1)$

INSERT INTO MANAGER(manager_id) VALUES(1)$
	

