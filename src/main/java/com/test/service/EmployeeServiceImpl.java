package com.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Employee;
import com.test.repositary.EmployeeRepositary;
@Service
public class EmployeeServiceImpl implements EmployeeService{
@Autowired
private EmployeeRepositary er;
	@Override
	public List<Employee> getAllEmployees() {
		return er.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		this.er.save(employee);
	}
	@Override
	public Employee getEmployeeById(long id) {
 Optional<Employee> optional = er.findById(id);
 Employee employee = null;
 if(optional.isPresent()) {
	  employee=optional.get();
 }else {
	 throw  new RuntimeException("not present:"+id);
 }
		return employee;
	}
	@Override
	public void deleteEmployeeById(long id) {
		this.er.deleteById(id);
	}
	

}
