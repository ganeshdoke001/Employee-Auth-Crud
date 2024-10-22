package com.employee.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeRequestDto;
import com.employee.dto.EmployeeResponseDto;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Service
public class EmployeeProcessor {

	@Autowired
	private EmployeeService service;

	public List<EmployeeResponseDto> getAll() {
		List<EmployeeResponseDto> employeeList = new ArrayList<>();
		List<Employee> empList = service.getAll();
		empList.stream().forEach(emp -> {
			EmployeeResponseDto employeeResponseDto = getEmployeeResponseDto(emp);
			employeeList.add(employeeResponseDto);
		});
		return employeeList;

	}

	public EmployeeResponseDto get(Long id) {
		EmployeeResponseDto employeeResponseDto = null;
		if (id != null) {
			Employee employee = service.get(id);
			employeeResponseDto = getEmployeeResponseDto(employee);
		}
		return employeeResponseDto;
	}

	public EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) {
		EmployeeResponseDto employeeResponseDto = null;
		if (employeeRequestDto != null) {
			Employee employee = service.save(getEmployee(employeeRequestDto));
			employeeResponseDto = getEmployeeResponseDto(employee);
		}

		return employeeResponseDto;
	}

	public EmployeeResponseDto update(EmployeeRequestDto employeeRequestDto, Long id) {
		EmployeeResponseDto employeeResponseDto = null;

		if (employeeRequestDto != null && id != null) {
			Employee employee = service.update(getEmployee(employeeRequestDto), id);
			employeeResponseDto = getEmployeeResponseDto(employee);
		}
		return employeeResponseDto;

	}

	public String delete(Long id) {
		if (id != null) {
			return service.delete(id);
		}
		return null;
	}

	private EmployeeResponseDto getEmployeeResponseDto(Employee employee) {
		EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
		employeeResponseDto.setId(employee.getId());
		employeeResponseDto.setName(employee.getName());
		employeeResponseDto.setPost(employee.getPost());
		employeeResponseDto.setSal(employee.getSal());
		employeeResponseDto.setEmail(employee.getEmail());
		employeeResponseDto.setPhone(employee.getPhone());
		employeeResponseDto.setJoinDate(employee.getJoinDate());
		employeeResponseDto.setLocation(employee.getLocation());
		return employeeResponseDto;
	}

	private Employee getEmployee(EmployeeRequestDto employeeDto) {
		Employee employee = new Employee();
		employee.setName(employeeDto.getName());
		employee.setPost(employeeDto.getPost());
		employee.setSal(employeeDto.getSal());
		employee.setEmail(employeeDto.getEmail());
		employee.setPhone(employeeDto.getPhone());
		employee.setJoinDate(employeeDto.getJoinDate());
		employee.setLocation(employeeDto.getLocation());
		return employee;
	}
}
