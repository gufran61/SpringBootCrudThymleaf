package com.test.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.Employee;
@Repository
public interface EmployeeRepositary extends JpaRepository<Employee, Long>{

}
