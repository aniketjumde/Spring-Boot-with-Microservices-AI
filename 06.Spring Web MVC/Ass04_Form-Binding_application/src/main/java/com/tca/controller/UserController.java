package com.tca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tca.model.User;


@Controller
public class UserController {

	
	@GetMapping("/form")
	public String showForm(Model model)
	{
		User u=new User();
	    model.addAttribute("user", u);
		
		return "Form";
	}
	
	@PostMapping("/register")
	public String handleForm(@ModelAttribute("user") User x,Model model)
	{
		
		System.out.println("User Details :"+x);
		model.addAttribute("uName",x.getUserName());
		model.addAttribute("uEmail",x.getEmailId());
		model.addAttribute("uPhone",x.getMobileNo());
		model.addAttribute("uGender",x.getGender());


		return "UserInformation";
	}
	
}
