package com.tca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tca.model.Employee;
import com.tca.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/view")
	public String showEmployee(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,Model model)
	{
		int pageSize=4;
		Page<Employee> emps=employeeService.findAll(pageNumber,pageSize);
		
		model.addAttribute("emps",emps);
		model.addAttribute("pageNumber", emps.getNumber());
		model.addAttribute("hasNext",emps.hasNext());
		model.addAttribute("hasPrevious", emps.hasPrevious());
		
		return "view";
	}
}
