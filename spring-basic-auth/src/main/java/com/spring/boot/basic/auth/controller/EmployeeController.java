package com.spring.boot.basic.auth.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.basic.auth.model.Employee;
import com.spring.boot.basic.auth.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/v1/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping(produces = {"application/json"})
  public ResponseEntity<Object> getAllEmployee() {
    log.debug("Fethcing all employees data from controller");
    List<Employee> allEmployees = employeeService.getAllEmployees();
    if (CollectionUtils.isEmpty(allEmployees)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Employees Found");
    }
    return ResponseEntity.status(HttpStatus.OK).body(allEmployees);
  }

  @GetMapping(path = "/{employeeId}", produces = {"application/json"})
  public ResponseEntity<Employee> getEmployeeByUuid(@PathVariable("employeeId") UUID employeeId) {
    log.debug("Fethcing all employees data from controller");
    return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeByUuid(employeeId));
  }

}
