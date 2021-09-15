package com.spring.boot.basic.auth.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.basic.auth.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
