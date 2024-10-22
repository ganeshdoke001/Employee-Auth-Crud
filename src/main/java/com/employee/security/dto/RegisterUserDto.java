package com.employee.security.dto;

import java.util.Objects;

import lombok.Data;

@Data
public class RegisterUserDto {

	private String email;

	private String password;

	private String fullName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public RegisterUserDto(String email, String password, String fullName) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
	}

	public RegisterUserDto() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, fullName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterUserDto other = (RegisterUserDto) obj;
		return Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "RegisterUserDto [email=" + email + ", password=" + password + ", fullName=" + fullName + "]";
	}

}
