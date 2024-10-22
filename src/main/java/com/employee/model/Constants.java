package com.employee.model;

import org.springframework.stereotype.Component;

@Component
public class Constants {

	private Constants() {
	}

	public static String EMPLOYEE_NOT_FOUND = " For given id ,employee is not found in DB";
	public static String EMPLOYEE_ALLREADY_EXIST = "Given employee details allready exist in the DB ";
	public static String INVALID_EMPLOYEE_DETAILS = "Given employee detatils are invalid";
	public static String EMPLOYEE_DELETED_SUCCESSFULYY = "Employee is deleted Successfully";

}
