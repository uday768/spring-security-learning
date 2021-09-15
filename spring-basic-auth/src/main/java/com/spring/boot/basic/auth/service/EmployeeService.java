package com.spring.boot.basic.auth.service;

import java.util.List;
import java.util.UUID;

import com.spring.boot.basic.auth.model.Employee;

public interface EmployeeService {

  public List<Employee> getAllEmployees();

  public Employee getEmployeeByUuid(UUID employeeId);

  public void updateEmployee(UUID employeeId, Employee employeeDto);

  public void deleteEmployeeByUuid(UUID employeeId);

}
