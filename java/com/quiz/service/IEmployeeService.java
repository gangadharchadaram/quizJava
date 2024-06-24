package com.quiz.service;

import java.util.List;
import com.quiz.model.Employee;
public interface IEmployeeService {
  Employee saveEmployee(Employee employee);

  List<Employee>fetchAllEmployee();

  Employee getEmployeeById(Long Id);

  Employee updateEmployeeById(Long Id,Employee employee);
  
  void deleteEmployeeById(Long Id);
}