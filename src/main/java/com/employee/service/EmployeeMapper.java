package com.employee.service;

import org.springframework.stereotype.Component;

import com.employee.dto.EmployeeRequestDto;
import com.employee.entity.Employee;

@Component
public class EmployeeMapper {

	public Employee mapToEmployee(EmployeeRequestDto employeeRequestDto) {
		Employee employee=new Employee();
		return employee;
		
	}
}
