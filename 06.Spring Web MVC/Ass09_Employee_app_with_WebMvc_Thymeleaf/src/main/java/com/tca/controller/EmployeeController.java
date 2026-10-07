package com.tca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tca.model.Employee;
import com.tca.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/show")
	public String showEmployee(Model model)
	{
		List<Employee> emps=employeeService.fetchAllEmployees();
		
		model.addAttribute("emps", emps);
		
		return "view";
	}
}
