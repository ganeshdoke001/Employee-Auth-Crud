package com.employee.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Employee_Details")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employee_Id")
	private Long id;

	@Column(name = "Employee_Name")
	private String name;

	@Column(name = "Employee_Post")
	private String post;

	@Column(name = "Employee_Sal")
	private Double sal;

	@Column(name = "Employee_Email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "Employee_Phone", length = 10, nullable = false, unique = true)
	private String phone;
	
	@Column(name = "Employee_JoinDate",nullable = false,updatable = false)
	private LocalDate joinDate;
	
	@Column(name = "Employee_Location")
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

	public Employee(Long id, String name, String post, Double sal, String email, String phone, LocalDate joinDate,
			String location) {
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

	public Employee() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, joinDate, location, name, phone, post, sal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(joinDate, other.joinDate) && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Objects.equals(post, other.post) && Objects.equals(sal, other.sal);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", post=" + post + ", sal=" + sal + ", email=" + email
				+ ", phone=" + phone + ", joinDate=" + joinDate + ", location=" + location + "]";
	}

}
