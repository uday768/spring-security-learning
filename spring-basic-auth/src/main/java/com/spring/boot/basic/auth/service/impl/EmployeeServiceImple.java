package com.spring.boot.basic.auth.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.boot.basic.auth.model.Employee;
import com.spring.boot.basic.auth.repo.EmployeeRepository;
import com.spring.boot.basic.auth.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class EmployeeServiceImple implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepo;

  @Override
  public List<Employee> getAllEmployees() {
    // TODO Auto-generated method stub
    log.debug("Fetching all the employees");
    return employeeRepo.findAll();
  }

  @Override
  public Employee getEmployeeByUuid(UUID employeeId) {
    // TODO Auto-generated method stub
    log.debug("Fetching the employee using the id {}", employeeId);
    Optional<Employee> employeeById = employeeRepo.findById(employeeId);
    Employee employee = employeeById.orElseThrow(() -> {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found. UUID: " + employeeId);
    });
    return employee;
  }

  @Override
  public void updateEmployee(UUID employeeId, Employee employeeDto) {
    // TODO Auto-generated method stub
    log.debug("Fetching the employee using the id {}", employeeId);
    Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);

    employeeOptional.orElseThrow(() -> {
      log.debug("Employee with Id {} is not available. Hence throwing exception");
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found. UUID: " + employeeId);
    });
    employeeOptional.ifPresent(employee -> {
      employee.setEmployeeAddress(employeeDto.getEmployeeAddress());
      employee.setEmployeeId(employeeId);
      employee.setEmployeeJoiningDate(employeeDto.getEmployeeJoiningDate());
      employee.setEmployeeName(employeeDto.getEmployeeName());
      employee.setEmployeeQualification(employeeDto.getEmployeeQualification());
      employeeRepo.save(employee);
    });
  }

  @Override
  public void deleteEmployeeByUuid(UUID employeeId) {
    // TODO Auto-generated method stub

    // TODO Auto-generated method stub
    log.debug("Fetching the employee using the id {}", employeeId);
    Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);

    employeeOptional.orElseThrow(() -> {
      log.debug("Employee with Id {} is not available. Hence throwing exception");
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found. UUID: " + employeeId);
    });

    log.debug("Invoking delete on employee with id {}", employeeId);
    employeeRepo.deleteById(employeeId);
  }

}
