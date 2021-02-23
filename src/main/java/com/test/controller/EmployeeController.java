package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.model.Employee;
import com.test.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService es;
@GetMapping("/")
	public String viewHomePage(Model model) {
	model.addAttribute("listOfEmployee", es.getAllEmployees());
		return "index";
		
	}
@GetMapping("/showNewEmployeeForm")
public String addNewEmployee(Model model) {
	Employee employee = new Employee();
	model.addAttribute("employee", employee);
	return "newEmployee";
	
}
@PostMapping("/saveEmployee")
public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	es.saveEmployee(employee);
	return "redirect:/";
	
}
@GetMapping("/showNewEmployeeForm/{id}")
public String showNewEmployeeForm(@PathVariable(value = "id") long id,Model model) {
	Employee employee=es.getEmployeeById(id);
	model.addAttribute("employee", employee);
	return "updateEmployee";
}
@GetMapping("/deleteEmployee/{id}")
public String deleteEmployee(@PathVariable(value = "id") long id) {
	es.deleteEmployeeById(id);
	return "redirect:/";
	
}
}
