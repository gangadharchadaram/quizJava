package com.quiz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Employee {
  @Id
  @Column(name = "empId")
  private Long EmpId;
  @Column(name = "empName")
  private String EmpName;
  private String Designation;
  }