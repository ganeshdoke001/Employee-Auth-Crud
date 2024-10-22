package com.employee.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeResponseDto {

	private Long id;

	private String name;

	private String post;

	private Double sal;

	private String email;

	private String phone;

	private LocalDate joinDate;

	private String location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public EmployeeResponseDto(Long id, String name, String post, Double sal, String email, String phone,
			LocalDate joinDate, String location) {
		super();
		this.id = id;
		this.name = name;
		this.post = post;
		this.sal = sal;
		this.email = email;
		this.phone = phone;
		this.joinDate = joinDate;
		this.location = location;
	}

	public EmployeeResponseDto() {
		super();
	}

}
