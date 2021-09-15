package com.spring.boot.basic.auth.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {

  @Id
  @JsonProperty("id")
  private UUID employeeId;

  @JsonProperty("name")
  private String employeeName;

  @JsonProperty("address")
  private String employeeAddress;

  @JsonProperty("qualification")
  private String employeeQualification;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
  @JsonProperty("joiningdate")
  private Timestamp employeeJoiningDate;
}
