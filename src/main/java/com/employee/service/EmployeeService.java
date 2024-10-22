package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {

	/**
	 * @return
	 */
	List<Employee> getAll();

	/**
	 * @param id
	 * @return
	 */
	Employee get(Long id);

	/**
	 * @param employee
	 * @return
	 */
	Employee save(Employee employee);

	/**
	 * @param employee
	 * @param id
	 * @return
	 */
	Employee update(Employee employee, Long id);

	/**
	 * @param id
	 * @return
	 */
	String delete(Long id);
}
