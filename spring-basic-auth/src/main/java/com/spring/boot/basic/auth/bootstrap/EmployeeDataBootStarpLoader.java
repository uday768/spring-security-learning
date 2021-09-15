package com.spring.boot.basic.auth.bootstrap;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.boot.basic.auth.model.Employee;
import com.spring.boot.basic.auth.repo.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class EmployeeDataBootStarpLoader implements CommandLineRunner {

  private final EmployeeRepository employeeRepository;

  @Override
  public void run(String... args) throws Exception {
    // TODO Auto-generated method stub
    log.debug("Started the process of loading the initail employee data to the h2 data base");
    loadEmployeeData();
  }

  public void loadEmployeeData() {
    List<Employee> employeeList = new ArrayList<Employee>();
    Date date = new Date();
    for (int i = 1; i <= 10; i++) {
      Employee emp = new Employee();
      emp.setEmployeeId(UUID.randomUUID());
      emp.setEmployeeAddress("D.No:" + i + " is my address");
      emp.setEmployeeName("Emp Name " + i);
      emp.setEmployeeQualification("Qualification" + i);
      emp.setEmployeeJoiningDate(new Timestamp(date.getTime()));
      employeeList.add(emp);
    }
    log.debug("Persisting the data to the db with size {}", employeeList.size());
    employeeRepository.saveAll(employeeList);
  }

}
