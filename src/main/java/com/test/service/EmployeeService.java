package com.test.service;

import java.util.List;



import com.test.model.Employee;

public interface EmployeeService {
public List<Employee> getAllEmployees();
public void saveEmployee(Employee employee);
public Employee getEmployeeById(long id);
public void deleteEmployeeById(long id);
}
