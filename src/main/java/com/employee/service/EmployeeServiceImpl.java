package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.exception.InvalidEmployeeDataException;
import com.employee.model.Constants;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<Employee> getAll() {

		try {
			return repo.findAll();
		} catch (Exception e) {
			throw new EmployeeNotFoundException(e.getMessage());
		}
	}

	@Override
	public Employee get(Long id) {
		try {
			Employee emp = repo.findById(id).orElse(null);
			if (emp != null) {
				return emp;
			} else {
				throw new EmployeeNotFoundException(Constants.EMPLOYEE_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new EmployeeNotFoundException(e.getMessage());
		}
	}

	@Override
	public Employee save(Employee employee) {
		try {
			return repo.save(employee);
		} catch (Exception e) {
			throw new InvalidEmployeeDataException(e.getMessage());
		}
	}

	@Override
	public Employee update(Employee employee, Long id) {
		try {
			Employee emp = repo.findById(id).orElse(null);
			if (emp != null) {
				employee.setId(id);
				return repo.save(employee);
			} else {
				throw new EmployeeNotFoundException(Constants.EMPLOYEE_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new InvalidEmployeeDataException(e.getMessage());
		}

	}

	@Override
	public String delete(Long id) {
		try {
			Employee emp = repo.findById(id).orElse(null);
			if(emp!=null) {
			repo.deleteById(id);
			return Constants.EMPLOYEE_DELETED_SUCCESSFULYY;
			}else {
				throw new EmployeeNotFoundException(Constants.EMPLOYEE_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new EmployeeNotFoundException(e.getMessage());
		}

	}

}
