package com.quiz.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.model.Employee;
import com.quiz.repository.EmployeeRepository;
@Service
public class EmployeeService  implements IEmployeeService{
  @Autowired
  private EmployeeRepository employeeRepository;
  @Override
  public Employee saveEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }
  @Override
  public List<Employee> fetchAllEmployee() {
    List<Employee> allEmployees =employeeRepository.findAll();
    return allEmployees;
  }
  @Override
  public Employee getEmployeeById(Long Id) {
    Optional<Employee> employee = employeeRepository.findById(Id);
    if(employee.isPresent()){
      return employee.get();
    }
    return null;
  }
  @Override
  public Employee updateEmployeeById(Long Id, Employee employee) {
    Optional<Employee> employee1 = employeeRepository.findById(Id);
    if (employee1.isPresent()){
      Employee originalEmployee = employee1.get();
      if (Objects.nonNull(employee.getEmpName()) && !"".equalsIgnoreCase(employee.getEmpName())) {
        originalEmployee.setEmpName(employee.getEmpName());
    }
    return employeeRepository.save(originalEmployee);
  }
  return null;
}
  @Override
  public void deleteEmployeeById(Long Id) {
      if (employeeRepository.findById(Id).isPresent()) {
          employeeRepository.deleteById(Id);
      }
  }
}







