package com.quiz.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.quiz.model.Employee;
import com.quiz.repository.EmployeeRepository;
import com.quiz.service.EmployeeService;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private EmployeeRepository empRepo;
  @PostMapping("/")
  public Employee saveEmployee(@RequestBody Employee employee){
    return employeeService.saveEmployee(employee);
  }
  @GetMapping("/")
  public List<Employee> getEmployees(){
    return employeeService.fetchAllEmployee();
  }
  @GetMapping("/{id}")
  public Employee getEmployeeById(@PathVariable("id") Long id){
    return employeeService.getEmployeeById(id);
  }
  @PutMapping("/{id}")
  public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
    empRepo.save(employee);
    return employee;
  }
  @DeleteMapping("/{id}/delete")
  public ResponseEntity<Object> deleteEmpolyee(@PathVariable Long id){
    employeeService.deleteEmployeeById(id);
    return ResponseEntity.noContent().build();
    // return employeeService.deleteEmployeeById(id);
  }
}