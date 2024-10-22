package com.employee.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.employee.dto.ApiResponse;
import com.employee.exception.EmployeeAllReadyExistException;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.exception.InvalidEmployeeDataException;

@ControllerAdvice
public class EmployeeAdviceController {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ApiResponse<String>> handleException(Exception ex) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponse<>(false, "An error occurred: " + ex.getMessage(), null));
	}

	@ExceptionHandler(EmployeeAllReadyExistException.class)
	@ResponseStatus(HttpStatus.IM_USED)
	public ResponseEntity<ApiResponse<String>> handleEmployeeAllReadyExistException(EmployeeAllReadyExistException ex) {
		return ResponseEntity.status(HttpStatus.IM_USED).body(new ApiResponse<>(false, ex.getMessage(), null));

	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ApiResponse<String>> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, ex.getMessage(), null));
	}

	@ExceptionHandler(InvalidEmployeeDataException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ApiResponse<String>> handleInvalidEmployeeDataException(InvalidEmployeeDataException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, ex.getMessage(), null));
	}
}
