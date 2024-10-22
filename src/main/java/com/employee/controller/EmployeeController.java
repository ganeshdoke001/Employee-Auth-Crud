package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.ApiResponse;
import com.employee.dto.EmployeeRequestDto;
import com.employee.dto.EmployeeResponseDto;
import com.employee.processor.EmployeeProcessor;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeProcessor processor;

	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ApiResponse<List<EmployeeResponseDto>>> getAll() {
		return ResponseEntity.ok(new ApiResponse<>(true, "Employees Data fetched successfully ", processor.getAll()));

	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ApiResponse<EmployeeResponseDto>> get(@PathVariable("id") Long id) {
		return ResponseEntity.ok(new ApiResponse<>(true,
				"Employee detatils fetched  successfully for employee Id : " + id, processor.get(id)));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ApiResponse<EmployeeResponseDto>> save(@RequestBody EmployeeRequestDto employeeRequestDto) {
		return ResponseEntity
				.ok(new ApiResponse<>(true, "Employee created successfully", processor.save(employeeRequestDto)));
	}

	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.CONTINUE)
	public ResponseEntity<ApiResponse<EmployeeResponseDto>> update(@RequestBody EmployeeRequestDto employeeRequestDto,
			@PathVariable("id") Long id) {
		return ResponseEntity.ok(new ApiResponse<>(true, "Employee updated successfully for id : " + id,
				processor.update(employeeRequestDto, id)));
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public ResponseEntity<ApiResponse<String>> delete(@PathVariable("id") Long id) {

		return ResponseEntity
				.ok(new ApiResponse<>(true, "Employee deleted successfully for id : " + id, processor.delete(id)));
	}
}
