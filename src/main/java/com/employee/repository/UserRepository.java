package com.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.User;

import jakarta.validation.constraints.NotNull;

public interface UserRepository extends JpaRepository<User, Long> {
	@NotNull
	Optional<User> findByEmail(String email);

}
